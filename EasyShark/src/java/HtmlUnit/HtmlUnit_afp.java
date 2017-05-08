package HtmlUnit;

import SQL.Conexion;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.apache.xerces.impl.dv.util.Base64;

public class HtmlUnit_afp {

    WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
    private String session_id;
    private int rut;
    private String dv;
    private String apePat;
    private String adm = "afp";
    private String tipo = "0";
    private String recaptcha_challenge_field;
    private String urlImagen;
    private String imagen;
    private String base;
    private String basePdf;
    private BigInteger idCliente;
    private boolean enCache = false;

    //Datos que se reciben despues de consultar
    private String afp;
    private String periodoActualizacion;
    private String fechaAfiliacion;

    public WebClient getWebClient() {
        return webClient;
    }

    public void setWebClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public boolean isEnCache() {
        return enCache;
    }

    public void setEnCache(boolean enCache) {
        this.enCache = enCache;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getApePat() {
        return apePat;
    }

    public void setApePat(String apePat) {
        this.apePat = apePat;
    }

    public String getAdm() {
        return adm;
    }

    public void setAdm(String adm) {
        this.adm = adm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecaptcha_challenge_field() {
        return recaptcha_challenge_field;
    }

    public void setRecaptcha_challenge_field(String recaptcha_challenge_field) {
        this.recaptcha_challenge_field = recaptcha_challenge_field;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getPeriodoActualizacion() {
        return periodoActualizacion;
    }

    public void setPeriodoActualizacion(String periodoActualizacion) {
        this.periodoActualizacion = periodoActualizacion;
    }

    public String getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(String fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    HtmlPage page;

    /**
     * Debe ser llenado manualmente el rut, dv, apePat
     *
     * @throws Exception
     */
    public void crearFormulario() throws Exception {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.OFF);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        page = webClient.getPage("http://www.safp.cl/apps/certificados/formConsultaAfiliacion.php");
        page.getWebClient().waitForBackgroundJavaScript(5000);

        this.recaptcha_challenge_field = page.getElementById("recaptcha_challenge_field").getAttribute("value");
        this.session_id = page.getElementByName("sessionid").getAttribute("value");
        this.urlImagen = page.getElementById("recaptcha_challenge_image").getAttribute("src");

        InputStream inp = webClient.getPage(this.urlImagen).getWebResponse().getContentAsStream();
        byte[] byteArray = IOUtils.toByteArray(inp);
        this.base = Base64.encode(byteArray);
    }

    public void submitForm2() throws IOException {
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(true);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        HtmlPage page = webClient.getPage("http://www.safp.cl/apps/certificados/formConsultaAfiliacion.php");
        page.getWebClient().waitForBackgroundJavaScript(5000);

        HtmlForm form = (HtmlForm) page.createElement("form");
        form.setAttribute("id", "formNueo");
        form.setAttribute("name", "datos");
        form.setMethodAttribute("POST");
        form.setActionAttribute("consultaAfiliacion.php");

        //session_id
        HtmlInput hSesionId = (HtmlInput) page.createElement("input");
        hSesionId.setAttribute("type", "hidden");
        hSesionId.setAttribute("name", "sessionid");
        hSesionId.setAttribute("value", this.session_id);
        form.appendChild(hSesionId);

        //adm
        HtmlInput hAdm = (HtmlInput) page.createElement("input");
        hAdm.setAttribute("type", "hidden");
        hAdm.setAttribute("name", "adm");
        hAdm.setAttribute("value", this.adm);
        form.appendChild(hAdm);

        //tipocons
        HtmlInput hTipoIco = (HtmlInput) page.createElement("input");
        hTipoIco.setAttribute("type", "hidden");
        hTipoIco.setAttribute("name", "tipocons");
        hTipoIco.setAttribute("value", this.tipo);
        form.appendChild(hTipoIco);

        //rut
        HtmlInput txtRut = (HtmlInput) page.createElement("input");
        txtRut.setAttribute("type", "text");
        txtRut.setAttribute("name", "rut");
        txtRut.setAttribute("value", this.rut + "");
        form.appendChild(txtRut);

        //dv
        HtmlInput txtDv = (HtmlInput) page.createElement("input");
        txtDv.setAttribute("type", "text");
        txtDv.setAttribute("name", "dv");
        txtDv.setAttribute("value", this.dv);
        form.appendChild(txtDv);

        //apepat
        HtmlInput txtApePat = (HtmlInput) page.createElement("input");
        txtApePat.setAttribute("type", "text");
        txtApePat.setAttribute("name", "apepat");
        txtApePat.setAttribute("value", this.apePat);
        form.appendChild(txtApePat);

        //recaptcha_challenge_field
        HtmlInput hrecaptcha_challenge_field = (HtmlInput) page.createElement("input");
        hrecaptcha_challenge_field.setAttribute("type", "hidden");
        hrecaptcha_challenge_field.setAttribute("name", "recaptcha_challenge_field");
        hrecaptcha_challenge_field.setAttribute("value", this.recaptcha_challenge_field);
        form.appendChild(hrecaptcha_challenge_field);

        //recaptcha_response_field
        HtmlInput hrecaptcha_response_field = (HtmlInput) page.createElement("input");
        hrecaptcha_response_field.setAttribute("type", "hidden");
        hrecaptcha_response_field.setAttribute("name", "recaptcha_response_field");
        hrecaptcha_response_field.setAttribute("value", this.imagen);
        form.appendChild(hrecaptcha_response_field);

        //Buscar
        HtmlInput hsubmit = (HtmlInput) page.createElement("input");
        hsubmit.setAttribute("type", "hidden");
        hsubmit.setAttribute("name", "submit");
        hsubmit.setAttribute("value", "Buscar");
        form.appendChild(hsubmit);

        HtmlButton btn = (HtmlButton) page.createElement("button");
        btn.setAttribute("id", "btnEnviarForm");
        btn.setAttribute("type", "submit");
        btn.setAttribute("name", "submit");
        btn.setAttribute("value", "Buscar");
        btn.setTextContent("Enviar Formulario");
        form.appendChild(btn);

        page.appendChild(form);

        HtmlPage page2 = btn.click();
        HtmlForm formResp = page2.getFormByName("persona");
        this.afp = formResp.getInputByName("afp").getValueAttribute();
        this.periodoActualizacion = formResp.getInputByName("periodo").getValueAttribute();
        this.fechaAfiliacion = formResp.getInputByName("fecafiafp").getValueAttribute();

        HtmlButton btn2 = (HtmlButton) page.createElement("button");
        btn2.setAttribute("type", "submit");
        formResp.appendChild(btn2);

        InputStream inp = btn2.click().getWebResponse().getContentAsStream();

        byte[] byteArray = IOUtils.toByteArray(inp);
        this.basePdf = Base64.encode(byteArray);
        webClient.close();
        guardarInformacion();
    }

    public void guardarInformacion() {
        Connection conn = null;
        try {
            conn = Conexion.getConexionEasy();
            String sql = "INSERT INTO easy.INFORMACION_PREVISIONAL (DOCUMENTO, FECHA_CONSULTA, CLIENTE_ID_CLIENTE)\n"
                    + "VALUES(?, CURRENT_TIMESTAMP,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, this.basePdf);
            pst.setString(2, this.idCliente.toString());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    //busca en la bbdd
    public boolean buscarInformacion() {
        Connection conn = null;
        boolean flag = false;
        try {
            conn = Conexion.getConexionEasy();
            String sql = "SELECT ID_INFOPREVISIONAL, DOCUMENTO, FECHA_CONSULTA\n"
                    + "FROM easy.INFORMACION_PREVISIONAL "
                    + "WHERE CLIENTE_ID_CLIENTE = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, this.idCliente.toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                flag = true;
                this.basePdf = rs.getString("DOCUMENTO");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("session_id", this.session_id);
        json.addProperty("rut", this.rut);
        json.addProperty("dv", this.dv);
        json.addProperty("apePat", this.apePat);
        json.addProperty("tipo", this.tipo);
        json.addProperty("adm", this.adm);
        json.addProperty("recaptcha_challenge_field", this.recaptcha_challenge_field);
        json.addProperty("urlImagen", this.urlImagen);
        json.addProperty("imagen", this.imagen);
        json.addProperty("afp", this.afp);
        json.addProperty("periodoActualizacion", this.periodoActualizacion);
        json.addProperty("fechaAfiliacion", this.fechaAfiliacion);
        json.addProperty("base", this.base);
        json.addProperty("basePdf", this.basePdf);
        json.addProperty("enCache", this.enCache);
        return json;
    }
}
