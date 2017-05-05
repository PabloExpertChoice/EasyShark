package HtmlUnit;

import cl.expertchoice.clases.CausaJudicial;
import cl.expertchoice.clases.Consultado;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

public class HtmlUnit_PJUDrut extends Thread {

    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private int rut;
    private String dv;
    private String docDemanda;
    private String tipoDocDemanda;
    private ArrayList<CausaJudicial> arrCausasJ = new ArrayList<>();

    HtmlPage page;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
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

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getDocDemanda() {
        return docDemanda;
    }

    public void setDocDemanda(String docDemanda) {
        this.docDemanda = docDemanda;
    }

    public String getTipoDocDemanda() {
        return tipoDocDemanda;
    }

    public void setTipoDocDemanda(String tipoDocDemanda) {
        this.tipoDocDemanda = tipoDocDemanda;
    }

    public HtmlPage getPage() {
        return page;
    }

    public void setPage(HtmlPage page) {
        this.page = page;
    }

    public ArrayList<CausaJudicial> getArrCausasJ() {
        return arrCausasJ;
    }

    public void setArrCausasJ(ArrayList<CausaJudicial> arrCausasJ) {
        this.arrCausasJ = arrCausasJ;
    }

    public static void main(String[] args) {
        HtmlUnit_PJUDrut ht = new HtmlUnit_PJUDrut();
        System.out.println("main");
        ht.setRut(15601206);
        ht.setDv("8");
        ht.buscarCausas();
    }

    @Override
    public void run() {
        try {
            Consultado conInsert = new Consultado();
            conInsert.setRut_cliente(this.rut);
            conInsert.setCausasJudiciales(arrCausasJ);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JsonObject buscarCausas() {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
        //JsonObject jsonResp = new JsonObject();
        JsonArray jsonArr = new JsonArray();

        try {
//            //Buscar causas en BBDDD
//            Consultado consultado = new BnCausaJudicial().consultarRut(rut, dv);
//            if (consultado != null) {
//                if (consultado.getCausasJudiciales().isEmpty()) {
//                    jsonResp.addProperty("estado", 405);
//                    jsonResp.addProperty("descripcion", "El cliente no posee causas judiciales");
//                } else {
//                    jsonResp.addProperty("estado", 200);
//                    jsonResp.add("causasJudiciales", new Gson().toJsonTree(consultado.getCausasJudiciales()));
//                }
//            } else {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.OFF);
            HtmlPage page = webClient.getPage("http://reca.poderjudicial.cl/RECAWEB/");
            HtmlPage body = (HtmlPage) page.getFrames().get(3).getEnclosedPage();
            for (int i = 2; i < body.getElementByName("RUT_Cod_Competencia").getElementsByTagName("option").getLength(); i++) {
                HtmlSelect selectCompetencia = (HtmlSelect) body.getElementByName("RUT_Cod_Competencia");
                selectCompetencia.setSelectedIndex(i);
                selectCompetencia.fireEvent("onchange");

                for (int j = 1; j < body.getElementByName("OPC_Cod_Corte").getElementsByTagName("option").getLength() - 1; j++) {
                    HtmlSelect selectCorte = (HtmlSelect) body.getElementByName("OPC_Cod_Corte");
                    selectCorte.setSelectedIndex(j);
                    selectCorte.fireEvent("onchange");
                    boolean tries = true;
                    while (tries) {
                        synchronized (body) {
                            body.wait(500); //wait
                        }
                        try {
                            if (body.getElementById("OPC_Cod_Tribunal").getElementsByTagName("option").getLength() >= 2) {
                                tries = false;
                            }
                        } catch (Exception ex) {
                        }
                    }
                    for (int k = 1; k < body.getElementByName("OPC_Cod_Tribunal").getElementsByTagName("option").getLength(); k++) {
                        HtmlSelect selectTribunal = (HtmlSelect) body.getElementByName("OPC_Cod_Tribunal");
                        selectTribunal.setSelectedIndex(k);

                        HtmlForm form = (HtmlForm) body.getElementByName("AtPublicoPpalForm");
                        form.getInputByName("RUT_Rut").setValueAttribute(rut + "");
                        form.getInputByName("RUT_Rut_Db").setValueAttribute(String.valueOf(dv));
                        String name = body.getElementById("randomfield").getTextContent();
                        body.getElementById("txtCaptcha").setAttribute("value", name);
                        HtmlButtonInput btn = (HtmlButtonInput) body.getElementById("divCaptcha").getElementsByTagName("tr").get(2).getElementsByTagName("input").get(0);
                        System.out.println(form.asXml());

//                        HtmlPage pageresultado = (HtmlPage) btn.click();
//                        System.out.println(i + " " + j + " " + k);
//                        try {
//                            HtmlListItem item = (HtmlListItem) pageresultado.getElementById("divRecursos").getElementsByTagName("tr").get(1);
//                            System.out.println(item.asXml());
//                        } catch (Exception e) {
//
//                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (FailingHttpStatusCodeException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            webClient.close();
        }

        return null;

//            int cantCompetencia = body.getElementByName("RUT_Cod_Competencia").getElementsByTagName("option").getLength();
//            for (int i = 2; i < cantCompetencia; i++) {
//                HtmlSelect selectCompetencia = (HtmlSelect) body.getElementByName("RUT_Cod_Competencia");
//                selectCompetencia.setSelectedIndex(i);
//                selectCompetencia.fireEvent("onchange");
//
//                int cantCorte = body.getElementByName("OPC_Cod_Corte").getElementsByTagName("option").getLength();
//                for (int j = 1; j < cantCorte; j++) {
//                    HtmlSelect OPC_Cod_Corte = (HtmlSelect) body.getElementById("OPC_Cod_Corte");
//                    OPC_Cod_Corte.setSelectedIndex(j);
//                    OPC_Cod_Corte.fireEvent("onchange");
//                    boolean tries2 = true;
//                    while (tries2) {
//                        synchronized (body) {
//                            body.wait(500); //wait
//                        }
//                        try {
//                            if (body.getElementById("OPC_Cod_Tribunal").getElementsByTagName("option").getLength() > 1) {
//                                tries2 = false;
//                            }
//                        } catch (Exception ex) {
//                        }
//                    }
//
////                    System.out.println(body.getElementByName("OPC_Cod_Tribunal").asXml());
//                    int cantTribunal = body.getElementByName("OPC_Cod_Tribunal").getElementsByTagName("option").getLength();
//                    for (int k = 1; k < cantTribunal; k++) {
//                        HtmlSelect OPC_Cod_Tribunal = (HtmlSelect) body.getElementById("OPC_Cod_Tribunal");
//                        OPC_Cod_Tribunal.setSelectedIndex(k);
//                        HtmlForm form = (HtmlForm) body.getElementByName("AtPublicoPpalForm");
//                        form.getInputByName("RUT_Rut").setValueAttribute(rut + "");
//                        form.getInputByName("RUT_Rut_Db").setValueAttribute(String.valueOf(dv));
//                        String name = body.getElementById("randomfield").getTextContent();
//                        body.getElementById("txtCaptcha").setAttribute("value", name);
////                        HtmlInput inputByValue = form.getInputByValue("Enviar");
////                        System.out.println(inputByValue.asXml());
//                        HtmlInput inpEnviar = (HtmlInput) body.getElementById("divCaptcha").getElementsByTagName("tr").get(2).getElementsByTagName("input").get(0);
//                        HtmlPage pageresultado = (HtmlPage) inpEnviar.click();
//
////                        System.out.println(selectCompetencia.getSelectedIndex() + " " + OPC_Cod_Corte.getSelectedIndex() + " " + OPC_Cod_Tribunal.getSelectedIndex());
////                        System.out.println(pageresultado.getElementById("divRecursos").getElementsByTagName("table").get(0).asXml());
////                        System.out.println("");
////                        System.out.println("");
//                        try {
//                            HtmlElement get = pageresultado.getElementById("divRecursos").getElementsByTagName("tr").get(1);
////                            System.out.println("aaaaaaaaaaaaa");
//                        } catch (Exception e) {
//
//                        }
////                        form.getElementsByTagName("input").get(2).click();
//
//                    }
//                }
//
//            }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (FailingHttpStatusCodeException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            webClient.close();
//        }
//        return null;
//            if (rut > 50000000) {
//                body.getElementById("tdTres").click();
//            } else {
//                body.getElementById("tdCuatro").click();
//            }
//            HtmlForm form = body.getForms().get(0);
//
//            if (this.rut >= 50000000) {
//                form.getInputByName("RUT_Consulta").setValueAttribute(this.rut + "");
//                form.getInputByName("RUT_DvConsulta").setValueAttribute(this.dv.trim().toUpperCase());
//            } else {
//                form.getInputByName("NOM_Consulta").setValueAttribute(this.nombre);
//                form.getInputByName("APE_Paterno").setValueAttribute(this.apePaterno);
//                form.getInputByName("APE_Materno").setValueAttribute(this.apeMaterno);
//            }
//            HtmlPage datos = form.getElementsByTagName("a").get(0).click();
//
//            //Resultados
//            HtmlTable resultados = (HtmlTable) datos.getElementById("contentCellsAddTabla");
//            DomNodeList filas = resultados.getElementsByTagName("tr");
////                ArrayList<CausaJudicial> arrCausasJ = new ArrayList<>();
//            for (int i = 0; i < filas.getLength(); i++) {
//                JsonObject json = new JsonObject();
//                HtmlTableRow row = (HtmlTableRow) filas.get(i);
//                String rol = row.getElementsByTagName("td").get(0).asText().trim();
//                String fecha = row.getElementsByTagName("td").get(1).asText().trim();
//                String caratulado = row.getElementsByTagName("td").get(2).asText().trim();
//                String tribunal = row.getElementsByTagName("td").get(3).asText().trim();
//
//                //Detalles
//                HtmlPage pageDetalles = row.getElementsByTagName("td").get(0).getElementsByTagName("a").get(0).click();
//                HtmlTable tablaDetalles = (HtmlTable) pageDetalles.getElementsByTagName("table").get(2);
//                HtmlTableDataCell td = (HtmlTableDataCell) tablaDetalles.getElementsByTagName("tr").get(3).getElementsByTagName("td").get(1);
//                String url = td.getElementsByTagName("img").get(0).getAttribute("onclick");
//                url = url.trim();
//                url = url.replace("ShowPDFCabecera('", "");
//                url = url.substring(0, url.length() - 2);
//                url = "http://civil.poderjudicial.cl/" + url;
//
//                HtmlTable tablaLitigantes = (HtmlTable) pageDetalles.getElementById("Litigantes").getElementsByTagName("table").get(1);
//                DomNodeList filasLitigantes = tablaLitigantes.getElementsByTagName("tr");
//                boolean isDemandado = false;
//                for (int j = 0; j < filasLitigantes.getLength(); j++) {
//                    HtmlTableRow row2 = (HtmlTableRow) filasLitigantes.get(j);
//                    String participante = row2.getElementsByTagName("td").get(0).getTextContent().trim();
//                    String rut2 = row2.getElementsByTagName("td").get(1).getTextContent();
//                    String rut3 = this.rut + "-" + this.dv;
//                    String nombre2 = row2.getElementsByTagName("td").get(3).getTextContent().trim();
//                    if (participante.equalsIgnoreCase("DDO.") && rut2.equalsIgnoreCase(rut3)) {
//                        isDemandado = true;
//                    }
//                }
//                if (isDemandado == true) {
//                    json.addProperty("rol", rol);
//                    json.addProperty("fecha", fecha);
//                    json.addProperty("caratulado", caratulado);
//                    json.addProperty("tribunal", tribunal);
//                    json.addProperty("documentoDemanda", url);
//                    jsonArr.add(json);
//
//                    try {
//                        CausaJudicial cauJ = new CausaJudicial();
//                        cauJ.setRol(rol);
//                        String[] arFec = fecha.split("/");
//                        cauJ.setFecha(arFec[2] + "-" + arFec[1] + "-" + arFec[0]);
//                        cauJ.setCaratulado(caratulado);
//                        cauJ.setTribunal(new Tribunal(0, tribunal));
//                        cauJ.setDocumentoDemanda(url);
//                        arrCausasJ.add(cauJ);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//
//            }
//
//            if (jsonArr.size() > 0) {
//
//                jsonResp.addProperty("estado", 200);
//                jsonResp.add("causasJudiciales", new Gson().toJsonTree(arrCausasJ));
//            } else {
//                jsonResp.addProperty("estado", 405);
//                jsonResp.addProperty("descripcion", "El cliente no posee causas judiciales");
//            }
////            }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } catch (FailingHttpStatusCodeException ex) {
//            ex.printStackTrace();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            webClient.close();
//        }
//        return jsonResp;
    }

    public void guardarDatosEnBBDD() {

    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("nombre", this.nombre);
        json.addProperty("apePaterno", this.apePaterno);
        json.addProperty("apeMaterno", this.apeMaterno);
        json.addProperty("rut", this.rut);
        json.addProperty("dv", this.dv);
        json.addProperty("docDemanda", this.docDemanda);
        json.addProperty("tipoDocDemanda", this.tipoDocDemanda);

        return json;
    }
}
