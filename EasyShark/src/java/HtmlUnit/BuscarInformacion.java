package HtmlUnit;

import cl.expertchoice.clases.Subsidiary;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import soporte.DescomponerNombre;

public class BuscarInformacion {

    public static void main(String[] args) {
        new BuscarInformacion().buscarEmpresa(18248767, "8");

    }

    public Subsidiary buscarPersona(int rut, String dv) {
        try {
            Subsidiary sub = null;
            WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.OFF);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);
            webClient.getOptions().setRedirectEnabled(false);
            HtmlPage page = webClient.getPage("https://chile.rutificador.com/");
            HtmlForm form = (HtmlForm) page.getElementById("form1");
            form.getInputByName("entrada").setValueAttribute(rut + "-" + dv);
            form.getElementsByTagName("input").get(2).click();
            boolean tries = true;
            while (tries) {
                synchronized (page) {
                    try {
                        page.wait(3000); //wait
                    } catch (InterruptedException ex) {

                    }
                }
                tries = false;
            }

            try {
                String nombreCompleto = page.getElementById("results").getElementsByTagName("a").get(0).getTextContent().trim().toUpperCase().replaceAll("  ", " ");
                DescomponerNombre d = new DescomponerNombre(nombreCompleto);
                d.descomponeApellidoNombre();
                sub = new Subsidiary();
                sub.setRut(rut);
                sub.setDv(dv);
                sub.setNombre(d.getNOMBRES().trim());
                sub.setApePaterno(d.getAPELLIDOP().trim());
                sub.setApeMaterno(d.getAPELLIDOM().trim());
                return sub;
            } catch (Exception e) {
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(BuscarInformacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (FailingHttpStatusCodeException ex) {
            Logger.getLogger(BuscarInformacion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Subsidiary buscarEmpresa(int rut, String dv) {
        Subsidiary sub = null;
        try {
            WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.OFF);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);
            webClient.getOptions().setRedirectEnabled(false);
            HtmlPage page = webClient.getPage("https://zeus.sii.cl/cvc_cgi/nar/nar_ingrut");
            HtmlForm form = (HtmlForm) page.getFormByName("form1");
            form.getInputByName("RUT").setValueAttribute(rut + "");
            form.getInputByName("DV").setValueAttribute(dv.toUpperCase());
            HtmlPage pageRe = (HtmlPage) form.getInputByName("ACEPTAR").click();
            HtmlTable resultados = (HtmlTable) pageRe.getElementsByTagName("table").get(2);
            String razonSocial = resultados.getElementsByTagName("td").get(0).getTextContent();
            if (razonSocial.equals("")) {
                return null;
            } else {
                sub = new Subsidiary();
                sub.setRut(rut);
                sub.setDv(dv);
                sub.setNombre(razonSocial);
                return sub;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
