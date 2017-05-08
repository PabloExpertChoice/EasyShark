/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.xml;

import cl.expertchoice.clases.Usuario;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.netbeans.saas.RestResponse;
import org.netbeans.saas.root.Rootwe;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author erick
 */
public class bnsInformacion {

    public JSONObject obtenerInformacion(String rut, Usuario usuario) {
        JSONObject json = null;
        try {
            String numSerie = "";
            String modo = "D";
            String misc = "1";
            String reescribe = "";
            String user = "ws.user";
            String pass = "ws.123456";
            

            RestResponse result = Rootwe.getXml(user, pass, rut, numSerie, modo, misc, reescribe);
            String xml = result.getDataAsString();
//            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response><status>10</status><descripcion>Rut ya se encuentra en la base de datos y no fue reescrito</descripcion><datosN><dct_detalle_antecedentes_de_riesgo_crediticio><evolucion_score>-</evolucion_score><labels_score>-</labels_score><mes_buenos>-</mes_buenos><mes_malos>-</mes_malos><percentil_poblacion>-</percentil_poblacion><probabilidad_real>-</probabilidad_real><rut_tipo>N</rut_tipo><score>940</score></dct_detalle_antecedentes_de_riesgo_crediticio><dct_detalle_antecedentes_laborales><actividades_economicas><act_eco><codigo>930990</codigo><glosa>OTRAS ACTIVIDADES DE SERVICIOS PERSONALES N.C.P.</glosa></act_eco><nro_actividades_economicas>1</nro_actividades_economicas></actividades_economicas><antecedentes_laborales><actividad_profesion>PROFESION NO CODIF</actividad_profesion><direccion>-</direccion><telefono>-</telefono></antecedentes_laborales></dct_detalle_antecedentes_laborales><dct_detalle_clasificador><clasificacion><resultado>-</resultado></clasificacion></dct_detalle_clasificador><dct_detalle_consultas_al_rut><nro_consultas>0</nro_consultas></dct_detalle_consultas_al_rut><dct_detalle_de_registros_de_morosidad_y_protestos><nro_mc_bic>0</nro_mc_bic></dct_detalle_de_registros_de_morosidad_y_protestos><dct_detalle_identificacion><cod_area>9</cod_area><cod_area_2>-</cod_area_2><dir_calle>-</dir_calle><dir_ciudad>-</dir_ciudad><dir_comuna>-</dir_comuna><dir_numero>-</dir_numero><dir_region>-</dir_region><dir_resto>-</dir_resto><direccion>-</direccion><edad>-</edad><email>-</email><estado_civil>-</estado_civil><fecha_civil>-</fecha_civil><fecha_de_nacimiento>-</fecha_de_nacimiento><nacionalidad>-</nacionalidad><nombre>IGNACIO LEONEL NARANJO LOPEZ</nombre><nro_direcciones_informadas>0</nro_direcciones_informadas><sexo>-</sexo><telefono>97867432</telefono><telefono_2>-</telefono_2></dct_detalle_identificacion><dct_detalle_indicadores_de_control><anota_vigentes_fecha_mas_reciente>-</anota_vigentes_fecha_mas_reciente><anota_vigentes_nro_documentos>0</anota_vigentes_nro_documentos><boletin_laboral_deudas>0</boletin_laboral_deudas><boletin_laboral_fecha_mas_reciente>-</boletin_laboral_fecha_mas_reciente><boletin_laboral_multas>0</boletin_laboral_multas><defuncion>NO</defuncion><estado_cedula>No ha consultado Estado de Cedula</estado_cedula><fecha_cedula>-</fecha_cedula><motivo>-</motivo><numero_serie>-</numero_serie><quiebra_fecha_mas_reciente>-</quiebra_fecha_mas_reciente><quiebra_numero_publicaciones>0</quiebra_numero_publicaciones></dct_detalle_indicadores_de_control><dct_detalle_individual_de_registros_de_morosidad_y_protestos><nro_indiv_mc_bic>0</nro_indiv_mc_bic></dct_detalle_individual_de_registros_de_morosidad_y_protestos><dct_detalle_informacion_positiva><bienes_raices_avaluo_fiscal_total>$ 0</bienes_raices_avaluo_fiscal_total><bienes_raices_nro_propiedades>0</bienes_raices_nro_propiedades><cmx_detalle><cmx_detalle_periodo_actual><ano_actual>0</ano_actual><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_actual><cmx_detalle_periodo_anterior><ano_anterior>0</ano_anterior><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_anterior></cmx_detalle><movimientos_de_bancos>-</movimientos_de_bancos><numero_vehiculos>0</numero_vehiculos><prendas_fecha_mas_reciente>-</prendas_fecha_mas_reciente><prendas_nro_acreedores>0</prendas_nro_acreedores><prendas_nro_prendas>0</prendas_nro_prendas><publicaciones_como_sociedad>0</publicaciones_como_sociedad><publicaciones_como_socio>0</publicaciones_como_socio><ultima_declaracion_de_impuestos>-</ultima_declaracion_de_impuestos><ultima_verificacion_de_domicilio>-</ultima_verificacion_de_domicilio></dct_detalle_informacion_positiva><dct_detalle_registro_orden_de_pago><nro_orden_de_pago>0</nro_orden_de_pago></dct_detalle_registro_orden_de_pago><dct_detalle_registros_de_protestos_y_morosidades><boletin_laboral><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></boletin_laboral><distribucion_periodos_acumulados><mas_de_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mas_de_24><mes_12_a_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_12_a_24><mes_6_a_12><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_6_a_12><ultimos_6_meses><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></ultimos_6_meses></distribucion_periodos_acumulados><morosidad_consolidada><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></morosidad_consolidada><protestos_vigentes><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></protestos_vigentes><totales><monto_total_bic_mc_bol>0</monto_total_bic_mc_bol><nro_acreedores_total_bic_mc_bol>0</nro_acreedores_total_bic_mc_bol><nro_documentos_total_bic_mc_bol>0</nro_documentos_total_bic_mc_bol><total_documentos>0</total_documentos></totales></dct_detalle_registros_de_protestos_y_morosidades><dct_resumen_anotacion_vigente><fecha_mas_reciente>-</fecha_mas_reciente><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></dct_resumen_anotacion_vigente><dct_resumen_boletin_laboral><acreedores>0</acreedores><fecha_mas_reciente>-</fecha_mas_reciente><total_documentos>0</total_documentos></dct_resumen_boletin_laboral></datosN></response>";
//            System.out.println(xml);
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            Document doc = db.parse(is);
            String[] arrRut = rut.split("-");
            int r = Integer.parseInt(arrRut[0]);
            json = new JSONObject();
            json.put("rut", r);
            json.put("dv", arrRut[1]);

            if (r >= 50000000) {
                json.put("score", consultar("//datosJ/dct_detalle_clasificador/clasificacion/resultado", doc));

                json.put("nombre", consultar("//datosJ/dct_detalle_identificacion/nombre", doc));
                json.put("nombre_fantasia", consultar("//datosJ/dct_detalle_identificacion/nombre_fantasia", doc));
                json.put("disolucion_vigente", consultar("//datosJ/dct_detalle_identificacion/disolucion_vigente", doc));
                json.put("fecha_disolucion", consultar("//datosJ/dct_detalle_identificacion/fecha_disolucion", doc));
                json.put("fecha_constitucion", consultar("//datosJ/dct_detalle_identificacion/fecha_constitucion", doc));
                json.put("rubro", consultar("//datosJ/dct_detalle_identificacion/rubro", doc));
                json.put("actividad", consultar("//datosJ/dct_detalle_identificacion/actividad", doc));
                json.put("fojas", consultar("//datosJ/dct_detalle_identificacion/fojas", doc));
                json.put("numero", consultar("//datosJ/dct_detalle_identificacion/numero", doc));
                json.put("direccion", consultar("//datosJ/dct_detalle_identificacion/direccion", doc));
                json.put("nro_direcciones_informadas", consultar("//datosJ/dct_detalle_identificacion/nro_direcciones_informadas", doc));
                json.put("codigo_postal", consultar("//datosJ/dct_detalle_identificacion/codigo_postal", doc));
                json.put("cod_area", consultar("//datosJ/dct_detalle_identificacion/cod_area", doc));
                json.put("cod_area_2", consultar("//datosJ/dct_detalle_identificacion/cod_area_2", doc));
                json.put("telefono", consultar("//datosJ/dct_detalle_identificacion/telefono", doc));
                json.put("telefono_2", consultar("//datosJ/dct_detalle_identificacion/telefono_2", doc));
                json.put("email", consultar("//datosJ/dct_detalle_identificacion/email", doc));
                json.put("ano", consultar("//datosJ/dct_detalle_identificacion/ano", doc));

                json.put("anota_vigentes_nro_documentos", consultar("//datosJ/dct_detalle_indicadores_de_control/anota_vigentes_nro_documentos", doc));
                json.put("anota_vigentes_fecha_mas_reciente", consultar("//datosJ/dct_detalle_indicadores_de_control/anota_vigentes_fecha_mas_reciente", doc));

                json.put("ano_actual", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/ano_actual", doc));
                json.put("nro_consultas", consultar("//datosJ/dct_detalle_consultas_al_rut/nro_consultas", doc));

                json.put("protestos_vigentes/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_acreedores", doc));
                json.put("protestos_vigentes/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_documentos", doc));
                json.put("protestos_vigentes/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/fecha_mas_reciente", doc));

                json.put("morosidad_consolidada/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_acreedores", doc));
                json.put("morosidad_consolidada/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_documentos", doc));
                json.put("morosidad_consolidada/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/fecha_mas_reciente", doc));

                json.put("ultimos_6_meses/periodo_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/ultimos_6_meses/periodo_documentos", doc));
                json.put("ultimos_6_meses/periodo_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/ultimos_6_meses/periodo_montos", doc));
                json.put("ultimos_6_meses/acumulado_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/ultimos_6_meses/acumulado_documentos", doc));
                json.put("ultimos_6_meses/acumulado_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/ultimos_6_meses/acumulado_montos", doc));

                json.put("mes_6_a_12/periodo_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_6_a_12/periodo_documentos", doc));
                json.put("mes_6_a_12/periodo_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_6_a_12/periodo_montos", doc));
                json.put("mes_6_a_12/acumulado_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_6_a_12/acumulado_documentos", doc));
                json.put("mes_6_a_12/acumulado_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_6_a_12/acumulado_montos", doc));

                json.put("mes_12_a_24/periodo_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_12_a_24/periodo_documentos", doc));
                json.put("mes_12_a_24/periodo_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_12_a_24/periodo_montos", doc));
                json.put("mes_12_a_24/acumulado_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_12_a_24/acumulado_documentos", doc));
                json.put("mes_12_a_24/acumulado_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mes_12_a_24/acumulado_montos", doc));

                json.put("mas_de_24/periodo_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mas_de_24/periodo_documentos", doc));
                json.put("mas_de_24/periodo_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mas_de_24/periodo_montos", doc));
                json.put("mas_de_24/acumulado_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mas_de_24/acumulado_documentos", doc));
                json.put("mas_de_24/acumulado_montos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/distribucion_periodos_acumulados/mas_de_24/acumulado_montos", doc));

                json.put("movimientos_de_bancos", consultar("//datosJ/dct_detalle_informacion_positiva/movimientos_de_bancos", doc));
                json.put("numero_vehiculos", consultar("//datosJ/dct_detalle_informacion_positiva/numero_vehiculos", doc));
                json.put("prendas_fecha_mas_reciente", consultar("//datosJ/dct_detalle_informacion_positiva/prendas_fecha_mas_reciente", doc));
                json.put("prendas_nro_acreedores", consultar("//datosJ/dct_detalle_informacion_positiva/prendas_nro_acreedores", doc));
                json.put("prendas_nro_prendas", consultar("//datosJ/dct_detalle_informacion_positiva/prendas_nro_prendas", doc));
                json.put("publicaciones_como_sociedad", consultar("//datosJ/dct_detalle_informacion_positiva/publicaciones_como_sociedad", doc));
                json.put("publicaciones_como_socio", consultar("//datosJ/dct_detalle_informacion_positiva/publicaciones_como_socio", doc));
                json.put("ultima_verificacion_de_domicilio", consultar("//datosJ/dct_detalle_informacion_positiva/ultima_verificacion_de_domicilio", doc));
                json.put("bienes_raices_nro_propiedades", consultar("//datosJ/dct_detalle_informacion_positiva/bienes_raices_nro_propiedades", doc));
                json.put("bienes_raices_avaluo_fiscal_total", consultar("//datosJ/dct_detalle_informacion_positiva/bienes_raices_avaluo_fiscal_total", doc));

                json.put("cmx_detalle_periodo_actual/ano_actual", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/ano_actual", doc));

                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/operaciones", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/operaciones", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/us", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/us", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ENE", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ENE", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/FEB", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/FEB", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAR", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ABR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ABR", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAY", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAY", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUN", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUN", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUL", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUL", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/AGO", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/AGO", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/SEP", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/SEP", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/OCT", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/OCT", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/NOV", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/NOV", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/DIC", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_exportaciones/DIC", doc));

                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/operaciones", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/operaciones", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/us", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/us", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/ENE", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/ENE", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/FEB", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/FEB", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAR", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/ABR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/ABR", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAY", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAY", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUN", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUN", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUL", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUL", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/AGO", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/AGO", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/SEP", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/SEP", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/OCT", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/OCT", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/NOV", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/NOV", doc));
                json.put("cmx_detalle_periodo_actual/cmx_detalle_importaciones/DIC", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_actual/cmx_detalle_importaciones/DIC", doc));

                json.put("cmx_detalle_periodo_anterior/ano_anterior", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/ano_anterior", doc));

                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/operaciones", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/operaciones", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/us", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/us", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ENE", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ENE", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/FEB", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/FEB", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAR", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ABR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ABR", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAY", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAY", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUN", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUN", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUL", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUL", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/AGO", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/AGO", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/SEP", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/SEP", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/OCT", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/OCT", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/NOV", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/NOV", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/DIC", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/DIC", doc));

                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/operaciones", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/operaciones", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/us", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/us", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ENE", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ENE", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/FEB", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/FEB", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAR", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ABR", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ABR", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAY", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAY", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUN", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUN", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUL", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUL", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/AGO", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/AGO", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/SEP", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/SEP", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/OCT", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/OCT", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/NOV", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/NOV", doc));
                json.put("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/DIC", consultar("//datosJ/dct_detalle_informacion_positiva/cmx_detalle/cmx_detalle_periodo_anterior/cmx_detalle_importaciones/DIC", doc));

                json.put("protestos_vigentes/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_documentos", doc));
                json.put("protestos_vigentes/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_acreedores", doc));
                json.put("protestos_vigentes/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/fecha_mas_reciente", doc));
                json.put("protestos_vigentes/monto_total", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/monto_total", doc));

                json.put("morosidad_consolidada/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_documentos", doc));
                json.put("morosidad_consolidada/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_acreedores", doc));
                json.put("morosidad_consolidada/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/fecha_mas_reciente", doc));
                json.put("morosidad_consolidada/monto_total", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/monto_total", doc));

                json.put("boletin_laboral/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/nro_documentos", doc));
                json.put("boletin_laboral/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/nro_acreedores", doc));
                json.put("boletin_laboral/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/fecha_mas_reciente", doc));
                json.put("boletin_laboral/monto_total", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/monto_total", doc));

                json.put("anotacion_vigente/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/nro_documentos", doc));
                json.put("anotacion_vigente/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/nro_acreedores", doc));
                json.put("anotacion_vigente/fecha_mas_reciente", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/fecha_mas_reciente", doc));
                json.put("anotacion_vigente/monto_total", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/monto_total", doc));

                json.put("totales/nro_documentos", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/totales/nro_documentos_total_bic_mc_bol", doc));
                json.put("totales/nro_acreedores", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/totales/nro_acreedores_total_bic_mc_bol", doc));
                json.put("totales/monto_total", consultar("//datosJ/dct_detalle_registros_de_protestos_y_morosidades/totales/monto_total_bic_mc_bol", doc));

                //Contactos de empresa
                JSONArray contactos = new JSONArray();
                int n = Integer.parseInt(consultar("count(//datosJ/dct_detalle_contactos_empresa/contacto_empresa)", doc));
                for (int i = 0; i < n; i++) {
                    JSONObject contacto = new JSONObject();
                    contacto.put("cargo", consultar("//datosJ/dct_detalle_contactos_empresa/contacto_empresa[" + (i + 1) + "]/cargo", doc));
                    contacto.put("nombre_razon", consultar("//datosJ/dct_detalle_contactos_empresa/contacto_empresa[" + (i + 1) + "]/nombre_razon", doc));
                    contacto.put("rut", consultar("//datosJ/dct_detalle_contactos_empresa/contacto_empresa[" + (i + 1) + "]/rut", doc));
                    contactos.put(contacto);
                }
                json.put("dct_detalle_contactos_empresa", contactos);

                JSONArray consultas = new JSONArray();
                n = Integer.parseInt(consultar("count(//datosJ/dct_detalle_consultas_al_rut/dct_consultas_al_rut)", doc));
                int con = 0;
                for (int i = 0; i < n; i++) {
                    JSONObject consulta = new JSONObject();
                    consulta.put("fecha_consulta", consultar("//datosJ/dct_detalle_consultas_al_rut/dct_consultas_al_rut[" + (i + 1) + "]/fecha_consulta", doc));

                    //Numero de cunsultas ultimos 6 meses
                    String d = consultar("//datosJ/dct_detalle_consultas_al_rut/dct_consultas_al_rut[" + (i + 1) + "]/fecha_consulta", doc);
                    int dia = Integer.parseInt(d.split("/")[0]);
                    int mes = Integer.parseInt(d.split("/")[1]);
                    int anio = Integer.parseInt(d.split("/")[2]);
                    Date fecha1 = new Date(mes + "/" + dia + "/" + anio);
                    Date fecha2 = restar6Meses();

                    if (fecha1.after(fecha2)) {
                        con = con + 1;
                    }
                    consulta.put("empresa", consultar("//datosJ/dct_detalle_consultas_al_rut/dct_consultas_al_rut[" + (i + 1) + "]/empresa", doc));
                    consulta.put("informe_solicitado", consultar("//datosJ/dct_detalle_consultas_al_rut/dct_consultas_al_rut[" + (i + 1) + "]/informe_solicitado", doc));
                    consultas.put(consulta);
                }
                json.put("num_consultas6Meses", con);
                json.put("dct_detalle_consultas_al_rut", consultas);

                //individual protesto y morosidad en evaluacion
                JSONArray prot = new JSONArray();
                n = Integer.parseInt(consultar("count(//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos)", doc));
                for (int i = 0; i < n; i++) {
                    JSONObject individual = new JSONObject();
                    individual.put("fecha_vencimiento", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/fecha_vencimiento", doc));
                    individual.put("tipo_documento", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/tipo_documento", doc));
                    individual.put("emisor_librador", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/emisor_librador", doc));
                    individual.put("localidad", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/localidad", doc));
                    individual.put("tipo_deuda", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/tipo_deuda", doc));
                    individual.put("moneda", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/moneda", doc));
                    individual.put("monto", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/monto", doc));
                    individual.put("motivo", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/motivo", doc));
                    individual.put("fecha_protesto", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/fecha_protesto", doc));
                    individual.put("tipo_credito", consultar("//datosJ/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestos[" + (i + 1) + "]/tipo_credito", doc));
                    prot.put(individual);
                }
                json.put("dct_detalle_individual_de_registros_de_morosidad_y_protestos", prot);

//                json.put("", consultar("//datosJ", doc));
            } else {
                json.put("score", consultar("//datosN/dct_detalle_antecedentes_de_riesgo_crediticio/score", doc));

                json.put("estado_cedula", consultar("//datosN/dct_detalle_indicadores_de_control/estado_cedula", doc));
                json.put("numero_serie", consultar("//datosN/dct_detalle_indicadores_de_control/numero_serie", doc));
                json.put("defuncion", consultar("//datosN/dct_detalle_indicadores_de_control/defuncion", doc));

                json.put("actividad_profesion", consultar("//datosN/dct_detalle_antecedentes_laborales/antecedentes_laborales/actividad_profesion", doc));

                json.put("protestos_vigentes/nro_documentos", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_documentos", doc));
                json.put("protestos_vigentes/nro_acreedores", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/nro_acreedores", doc));
                json.put("protestos_vigentes/fecha_mas_reciente", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/fecha_mas_reciente", doc));
                json.put("protestos_vigentes/monto_total", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/protestos_vigentes/monto_total", doc));

                json.put("morosidad_consolidada/nro_documentos", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_documentos", doc));
                json.put("morosidad_consolidada/nro_acreedores", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/nro_acreedores", doc));
                json.put("morosidad_consolidada/fecha_mas_reciente", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/fecha_mas_reciente", doc));
                json.put("morosidad_consolidada/monto_total", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/morosidad_consolidada/monto_total", doc));

                json.put("boletin_laboral/nro_documentos", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/nro_documentos", doc));
                json.put("boletin_laboral/nro_acreedores", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/nro_acreedores", doc));
                json.put("boletin_laboral/fecha_mas_reciente", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/fecha_mas_reciente", doc));
                json.put("boletin_laboral/monto_total", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/boletin_laboral/monto_total", doc));

                json.put("anotacion_vigente/nro_documentos", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/nro_documentos", doc));
                json.put("anotacion_vigente/nro_acreedores", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/nro_acreedores", doc));
                json.put("anotacion_vigente/fecha_mas_reciente", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/fecha_mas_reciente", doc));
                json.put("anotacion_vigente/monto_total", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/anotacion_vigente/monto_total", doc));

                json.put("totales/nro_documentos", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/totales/nro_documentos_total_bic_mc_bol", doc));
                json.put("totales/nro_acreedores", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/totales/nro_acreedores_total_bic_mc_bol", doc));
                json.put("totales/monto_total", consultar("//datosN/dct_detalle_registros_de_protestos_y_morosidades/totales/monto_total_bic_mc_bol", doc));

//                json.put("", consultar("//datosN/", doc));
                json.put("nombre", consultar("//datosN/dct_detalle_identificacion/nombre", doc));
                json.put("email", consultar("//datosN/dct_detalle_identificacion/email", doc));
                json.put("cod_area", consultar("//datosN/dct_detalle_identificacion/cod_area", doc));
                json.put("telefono", consultar("//datosN/dct_detalle_identificacion/telefono", doc));
                json.put("cod_area_2", consultar("//datosN/dct_detalle_identificacion/cod_area_2", doc));
                json.put("telefono_2", consultar("//datosN/dct_detalle_identificacion/telefono_2", doc));
                json.put("nro_direcciones_informadas", consultar("//datosN/dct_detalle_identificacion/nro_direcciones_informadas", doc));
                json.put("direccion", consultar("//datosN/dct_detalle_identificacion/direccion", doc));
                json.put("dir_calle", consultar("//datosN/dct_detalle_identificacion/dir_calle", doc));
                json.put("dir_numero", consultar("//datosN/dct_detalle_identificacion/dir_numero", doc));
                json.put("dir_comuna", consultar("//datosN/dct_detalle_identificacion/dir_comuna", doc));
                json.put("dir_ciudad", consultar("//datosN/dct_detalle_identificacion/dir_ciudad", doc));
                json.put("dir_region", consultar("//datosN/dct_detalle_identificacion/dir_region", doc));
                json.put("dir_resto", consultar("//datosN/dct_detalle_identificacion/dir_resto", doc));
                json.put("fecha_de_nacimiento", consultar("//datosN/dct_detalle_identificacion/fecha_de_nacimiento", doc));
                json.put("edad", consultar("//datosN/dct_detalle_identificacion/edad", doc));
                json.put("sexo", consultar("//datosN/dct_detalle_identificacion/sexo", doc));
                json.put("nacionalidad", consultar("//datosN/dct_detalle_identificacion/nacionalidad", doc));
                json.put("estado_civil", consultar("//datosN/dct_detalle_identificacion/estado_civil", doc));
                json.put("fecha_civil", consultar("//datosN/dct_detalle_identificacion/fecha_civil", doc));

                json.put("movimientos_de_bancos", consultar("//datosN/dct_detalle_informacion_positiva/movimientos_de_bancos", doc));
                json.put("numero_vehiculos", consultar("//datosN/dct_detalle_informacion_positiva/numero_vehiculos", doc));

                json.put("dct_resumen_anotacion_vigente/nro_documentos", consultar("//datosN/dct_resumen_anotacion_vigente/nro_documentos", doc));
                json.put("dct_resumen_anotacion_vigente/nro_acreedores", consultar("//datosN/dct_resumen_anotacion_vigente/nro_acreedores", doc));
                json.put("dct_resumen_anotacion_vigente/fecha_mas_reciente", consultar("//datosN/dct_resumen_anotacion_vigente/fecha_mas_reciente", doc));

                json.put("dct_resumen_boletin_laboral/total_documentos", consultar("//datosN/dct_resumen_boletin_laboral/total_documentos", doc));
                json.put("dct_resumen_boletin_laboral/acreedores", consultar("//datosN/dct_resumen_boletin_laboral/acreedores", doc));
                json.put("dct_resumen_boletin_laboral/fecha_mas_reciente", consultar("//datosN/dct_resumen_boletin_laboral/fecha_mas_reciente", doc));

                /**
                 * Consultas al rut.
                 */
                JSONArray consultas = new JSONArray();
                int n = Integer.parseInt(consultar("count(//datosN/dct_detalle_consultas_al_rut/dct_consultas_al_rutN)", doc));
                int con = 0;
                for (int i = 0; i < n; i++) {
                    JSONObject consulta = new JSONObject();
                    consulta.put("fecha_consulta", consultar("//datosN/dct_detalle_consultas_al_rut/dct_consultas_al_rutN[" + (i + 1) + "]/fecha_consulta", doc));

                    //Numero de consultas al rut ultimos 6 meses
                    String d = consultar("//datosN/dct_detalle_consultas_al_rut/dct_consultas_al_rutN[" + (i + 1) + "]/fecha_consulta", doc);
                    int dia = Integer.parseInt(d.split("/")[0]);
                    int mes = Integer.parseInt(d.split("/")[1]);
                    int anio = Integer.parseInt(d.split("/")[2]);
                    Date fecha1 = new Date(mes + "/" + dia + "/" + anio);
                    Date fecha2 = restar6Meses();

                    if (fecha1.after(fecha2)) {
                        con = con + 1;
                    }

                    consulta.put("empresa", consultar("//datosN/dct_detalle_consultas_al_rut/dct_consultas_al_rutN[" + (i + 1) + "]/empresa", doc));
                    consulta.put("informe_solicitado", consultar("//datosN/dct_detalle_consultas_al_rut/dct_consultas_al_rutN[" + (i + 1) + "]/informe_solicitado", doc));
                    consultas.put(consulta);
                }
                json.put("num_consultas6Meses", con);
                json.put("dct_detalle_consultas_al_rut", consultas);

                /**
                 * actividades economicas.
                 */
                JSONArray actividades = new JSONArray();
                n = Integer.parseInt(consultar("count(//datosN/dct_detalle_antecedentes_laborales/actividades_economicas/act_eco)", doc));
                for (int i = 0; i < n; i++) {
                    JSONObject actividad = new JSONObject();
                    actividad.put("glosa", consultar("//datosN/dct_detalle_antecedentes_laborales/actividades_economicas/act_eco[" + (i + 1) + "]/glosa", doc));
                    actividades.put(actividad);
                }
                json.put("dct_detalle_antecedentes_laborales", actividades);

                //individual protesto y morosidad en evaluacion
                JSONArray prot = new JSONArray();
                n = Integer.parseInt(consultar("count(//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN)", doc));
                for (int i = 0; i < n; i++) {
                    JSONObject individual = new JSONObject();
                    individual.put("fecha_vencimiento", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/fecha_vencimiento", doc));
                    individual.put("tipo_documento", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/tipo_documento", doc));
                    individual.put("emisor_librador", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/emisor_librador", doc));
                    individual.put("localidad", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/localidad", doc));
                    individual.put("tipo_deuda", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/tipo_deuda", doc));
                    individual.put("moneda", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/moneda", doc));
                    individual.put("monto", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/monto", doc));
                    individual.put("motivo", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/motivo", doc));
                    individual.put("fecha_protesto", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/fecha_protesto", doc));
                    individual.put("tipo_credito", consultar("//datosN/dct_detalle_individual_de_registros_de_morosidad_y_protestos/dct_individual_de_registros_de_morosidad_y_protestosN[" + (i + 1) + "]/tipo_credito", doc));
                    prot.put(individual);
                }
                json.put("dct_detalle_individual_de_registros_de_morosidad_y_protestos", prot);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return json;
    }

    /**
     * Funcion que permite filtar informacion en el String o respuesta que
     * estamos trabajando, esta funcion se llama muchas veces durante el codigo,
     * y permite hacer cualquier tipo de consulta sobre un documento XML.
     *
     * @param Expresion es el String que tiene la sintaxis para ubicar algun
     * tipo de dato en el documento
     * @return el valor del campo solicitado si es que existe y si no existe
     * devuelve un valor por defecto que en este caso es vacio.
     * @throws XPathExpressionException representa un error si es que existiese
     * en la expresion de tipo XPATH (libreria utilizada para realizar consultas
     * a un xml)
     * @throws FileNotFoundException esta excepcion la manejamos para controlar
     * errores en el caso de que el archivo al cual queremos acceder exista o en
     * el caso de que existiese el archivo, pero solo tuviese permisos de
     * escritura.
     */
    public static String consultar(String Expresion, Document doc) throws XPathExpressionException, FileNotFoundException {

        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression xPathExpression = xPath.compile(Expresion);
        String consulta = xPathExpression.evaluate(doc);

        if (!"".equals(consulta)) {
            return consulta;
        } else {
            return "--";
        }

    }

    public static Date restar6Meses() {
        Date fch = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MONTH, -6);

        return new java.sql.Date(cal.getTimeInMillis());
    }

    public JSONObject obtenerNombre(String rut) {
        try {
            String user = "consultaMotor";
            String pass = "passMotor";

            RestResponse result = Rootwe.getXmlIdentificacion(rut, user, pass);
            String xml = result.getDataAsString();
//            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response><status>10</status><descripcion>Rut ya se encuentra en la base de datos y no fue reescrito</descripcion><datosN><dct_detalle_antecedentes_de_riesgo_crediticio><evolucion_score>-</evolucion_score><labels_score>-</labels_score><mes_buenos>-</mes_buenos><mes_malos>-</mes_malos><percentil_poblacion>-</percentil_poblacion><probabilidad_real>-</probabilidad_real><rut_tipo>N</rut_tipo><score>940</score></dct_detalle_antecedentes_de_riesgo_crediticio><dct_detalle_antecedentes_laborales><actividades_economicas><act_eco><codigo>930990</codigo><glosa>OTRAS ACTIVIDADES DE SERVICIOS PERSONALES N.C.P.</glosa></act_eco><nro_actividades_economicas>1</nro_actividades_economicas></actividades_economicas><antecedentes_laborales><actividad_profesion>PROFESION NO CODIF</actividad_profesion><direccion>-</direccion><telefono>-</telefono></antecedentes_laborales></dct_detalle_antecedentes_laborales><dct_detalle_clasificador><clasificacion><resultado>-</resultado></clasificacion></dct_detalle_clasificador><dct_detalle_consultas_al_rut><nro_consultas>0</nro_consultas></dct_detalle_consultas_al_rut><dct_detalle_de_registros_de_morosidad_y_protestos><nro_mc_bic>0</nro_mc_bic></dct_detalle_de_registros_de_morosidad_y_protestos><dct_detalle_identificacion><cod_area>9</cod_area><cod_area_2>-</cod_area_2><dir_calle>-</dir_calle><dir_ciudad>-</dir_ciudad><dir_comuna>-</dir_comuna><dir_numero>-</dir_numero><dir_region>-</dir_region><dir_resto>-</dir_resto><direccion>-</direccion><edad>-</edad><email>-</email><estado_civil>-</estado_civil><fecha_civil>-</fecha_civil><fecha_de_nacimiento>-</fecha_de_nacimiento><nacionalidad>-</nacionalidad><nombre>IGNACIO LEONEL NARANJO LOPEZ</nombre><nro_direcciones_informadas>0</nro_direcciones_informadas><sexo>-</sexo><telefono>97867432</telefono><telefono_2>-</telefono_2></dct_detalle_identificacion><dct_detalle_indicadores_de_control><anota_vigentes_fecha_mas_reciente>-</anota_vigentes_fecha_mas_reciente><anota_vigentes_nro_documentos>0</anota_vigentes_nro_documentos><boletin_laboral_deudas>0</boletin_laboral_deudas><boletin_laboral_fecha_mas_reciente>-</boletin_laboral_fecha_mas_reciente><boletin_laboral_multas>0</boletin_laboral_multas><defuncion>NO</defuncion><estado_cedula>No ha consultado Estado de Cedula</estado_cedula><fecha_cedula>-</fecha_cedula><motivo>-</motivo><numero_serie>-</numero_serie><quiebra_fecha_mas_reciente>-</quiebra_fecha_mas_reciente><quiebra_numero_publicaciones>0</quiebra_numero_publicaciones></dct_detalle_indicadores_de_control><dct_detalle_individual_de_registros_de_morosidad_y_protestos><nro_indiv_mc_bic>0</nro_indiv_mc_bic></dct_detalle_individual_de_registros_de_morosidad_y_protestos><dct_detalle_informacion_positiva><bienes_raices_avaluo_fiscal_total>$ 0</bienes_raices_avaluo_fiscal_total><bienes_raices_nro_propiedades>0</bienes_raices_nro_propiedades><cmx_detalle><cmx_detalle_periodo_actual><ano_actual>0</ano_actual><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_actual><cmx_detalle_periodo_anterior><ano_anterior>0</ano_anterior><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_anterior></cmx_detalle><movimientos_de_bancos>-</movimientos_de_bancos><numero_vehiculos>0</numero_vehiculos><prendas_fecha_mas_reciente>-</prendas_fecha_mas_reciente><prendas_nro_acreedores>0</prendas_nro_acreedores><prendas_nro_prendas>0</prendas_nro_prendas><publicaciones_como_sociedad>0</publicaciones_como_sociedad><publicaciones_como_socio>0</publicaciones_como_socio><ultima_declaracion_de_impuestos>-</ultima_declaracion_de_impuestos><ultima_verificacion_de_domicilio>-</ultima_verificacion_de_domicilio></dct_detalle_informacion_positiva><dct_detalle_registro_orden_de_pago><nro_orden_de_pago>0</nro_orden_de_pago></dct_detalle_registro_orden_de_pago><dct_detalle_registros_de_protestos_y_morosidades><boletin_laboral><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></boletin_laboral><distribucion_periodos_acumulados><mas_de_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mas_de_24><mes_12_a_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_12_a_24><mes_6_a_12><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_6_a_12><ultimos_6_meses><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></ultimos_6_meses></distribucion_periodos_acumulados><morosidad_consolidada><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></morosidad_consolidada><protestos_vigentes><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></protestos_vigentes><totales><monto_total_bic_mc_bol>0</monto_total_bic_mc_bol><nro_acreedores_total_bic_mc_bol>0</nro_acreedores_total_bic_mc_bol><nro_documentos_total_bic_mc_bol>0</nro_documentos_total_bic_mc_bol><total_documentos>0</total_documentos></totales></dct_detalle_registros_de_protestos_y_morosidades><dct_resumen_anotacion_vigente><fecha_mas_reciente>-</fecha_mas_reciente><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></dct_resumen_anotacion_vigente><dct_resumen_boletin_laboral><acreedores>0</acreedores><fecha_mas_reciente>-</fecha_mas_reciente><total_documentos>0</total_documentos></dct_resumen_boletin_laboral></datosN></response>";
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            Document doc = db.parse(is);
            String[] arrRut = rut.split("-");
            int r = Integer.parseInt(arrRut[0]);

            if (!consultar("//nombre", doc).equalsIgnoreCase("--")) {
                JSONObject json  = new JSONObject();
                json.put("rut", r);
                json.put("dv", arrRut[1]);
                String nom_com = consultar("//nombre", doc) + " " + consultar("//ape_paterno", doc) + " " + consultar("//ape_materno", doc);
                json.put("nombre", nom_com.replaceAll("  ", " "));
                return json;
            }
            return null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public JSONObject obtenerNombreDelSII(String rut) {
        JSONObject json = null;
        try {
            String user = "test1234";
            String pass = "test5678";

            RestResponse result = Rootwe.getXmlSII(rut, user, pass);
            String xml = result.getDataAsString();
//            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response><status>10</status><descripcion>Rut ya se encuentra en la base de datos y no fue reescrito</descripcion><datosN><dct_detalle_antecedentes_de_riesgo_crediticio><evolucion_score>-</evolucion_score><labels_score>-</labels_score><mes_buenos>-</mes_buenos><mes_malos>-</mes_malos><percentil_poblacion>-</percentil_poblacion><probabilidad_real>-</probabilidad_real><rut_tipo>N</rut_tipo><score>940</score></dct_detalle_antecedentes_de_riesgo_crediticio><dct_detalle_antecedentes_laborales><actividades_economicas><act_eco><codigo>930990</codigo><glosa>OTRAS ACTIVIDADES DE SERVICIOS PERSONALES N.C.P.</glosa></act_eco><nro_actividades_economicas>1</nro_actividades_economicas></actividades_economicas><antecedentes_laborales><actividad_profesion>PROFESION NO CODIF</actividad_profesion><direccion>-</direccion><telefono>-</telefono></antecedentes_laborales></dct_detalle_antecedentes_laborales><dct_detalle_clasificador><clasificacion><resultado>-</resultado></clasificacion></dct_detalle_clasificador><dct_detalle_consultas_al_rut><nro_consultas>0</nro_consultas></dct_detalle_consultas_al_rut><dct_detalle_de_registros_de_morosidad_y_protestos><nro_mc_bic>0</nro_mc_bic></dct_detalle_de_registros_de_morosidad_y_protestos><dct_detalle_identificacion><cod_area>9</cod_area><cod_area_2>-</cod_area_2><dir_calle>-</dir_calle><dir_ciudad>-</dir_ciudad><dir_comuna>-</dir_comuna><dir_numero>-</dir_numero><dir_region>-</dir_region><dir_resto>-</dir_resto><direccion>-</direccion><edad>-</edad><email>-</email><estado_civil>-</estado_civil><fecha_civil>-</fecha_civil><fecha_de_nacimiento>-</fecha_de_nacimiento><nacionalidad>-</nacionalidad><nombre>IGNACIO LEONEL NARANJO LOPEZ</nombre><nro_direcciones_informadas>0</nro_direcciones_informadas><sexo>-</sexo><telefono>97867432</telefono><telefono_2>-</telefono_2></dct_detalle_identificacion><dct_detalle_indicadores_de_control><anota_vigentes_fecha_mas_reciente>-</anota_vigentes_fecha_mas_reciente><anota_vigentes_nro_documentos>0</anota_vigentes_nro_documentos><boletin_laboral_deudas>0</boletin_laboral_deudas><boletin_laboral_fecha_mas_reciente>-</boletin_laboral_fecha_mas_reciente><boletin_laboral_multas>0</boletin_laboral_multas><defuncion>NO</defuncion><estado_cedula>No ha consultado Estado de Cedula</estado_cedula><fecha_cedula>-</fecha_cedula><motivo>-</motivo><numero_serie>-</numero_serie><quiebra_fecha_mas_reciente>-</quiebra_fecha_mas_reciente><quiebra_numero_publicaciones>0</quiebra_numero_publicaciones></dct_detalle_indicadores_de_control><dct_detalle_individual_de_registros_de_morosidad_y_protestos><nro_indiv_mc_bic>0</nro_indiv_mc_bic></dct_detalle_individual_de_registros_de_morosidad_y_protestos><dct_detalle_informacion_positiva><bienes_raices_avaluo_fiscal_total>$ 0</bienes_raices_avaluo_fiscal_total><bienes_raices_nro_propiedades>0</bienes_raices_nro_propiedades><cmx_detalle><cmx_detalle_periodo_actual><ano_actual>0</ano_actual><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_actual><cmx_detalle_periodo_anterior><ano_anterior>0</ano_anterior><cmx_detalle_exportaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_exportaciones><cmx_detalle_importaciones><ABR>*</ABR><AGO>*</AGO><DIC>*</DIC><ENE>*</ENE><FEB>*</FEB><JUL>*</JUL><JUN>*</JUN><MAR>*</MAR><MAY>*</MAY><NOV>*</NOV><OCT>*</OCT><operaciones>-</operaciones><SEP>*</SEP><us>-</us></cmx_detalle_importaciones></cmx_detalle_periodo_anterior></cmx_detalle><movimientos_de_bancos>-</movimientos_de_bancos><numero_vehiculos>0</numero_vehiculos><prendas_fecha_mas_reciente>-</prendas_fecha_mas_reciente><prendas_nro_acreedores>0</prendas_nro_acreedores><prendas_nro_prendas>0</prendas_nro_prendas><publicaciones_como_sociedad>0</publicaciones_como_sociedad><publicaciones_como_socio>0</publicaciones_como_socio><ultima_declaracion_de_impuestos>-</ultima_declaracion_de_impuestos><ultima_verificacion_de_domicilio>-</ultima_verificacion_de_domicilio></dct_detalle_informacion_positiva><dct_detalle_registro_orden_de_pago><nro_orden_de_pago>0</nro_orden_de_pago></dct_detalle_registro_orden_de_pago><dct_detalle_registros_de_protestos_y_morosidades><boletin_laboral><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></boletin_laboral><distribucion_periodos_acumulados><mas_de_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mas_de_24><mes_12_a_24><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_12_a_24><mes_6_a_12><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></mes_6_a_12><ultimos_6_meses><acumulado_documentos>0</acumulado_documentos><acumulado_montos>0</acumulado_montos><periodo_documentos>0</periodo_documentos><periodo_montos>0</periodo_montos></ultimos_6_meses></distribucion_periodos_acumulados><morosidad_consolidada><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></morosidad_consolidada><protestos_vigentes><fecha_mas_reciente>-</fecha_mas_reciente><monto_promedio>0</monto_promedio><monto_total>0</monto_total><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></protestos_vigentes><totales><monto_total_bic_mc_bol>0</monto_total_bic_mc_bol><nro_acreedores_total_bic_mc_bol>0</nro_acreedores_total_bic_mc_bol><nro_documentos_total_bic_mc_bol>0</nro_documentos_total_bic_mc_bol><total_documentos>0</total_documentos></totales></dct_detalle_registros_de_protestos_y_morosidades><dct_resumen_anotacion_vigente><fecha_mas_reciente>-</fecha_mas_reciente><nro_acreedores>0</nro_acreedores><nro_documentos>0</nro_documentos></dct_resumen_anotacion_vigente><dct_resumen_boletin_laboral><acreedores>0</acreedores><fecha_mas_reciente>-</fecha_mas_reciente><total_documentos>0</total_documentos></dct_resumen_boletin_laboral></datosN></response>";
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            Document doc = db.parse(is);
            String[] arrRut = rut.split("-");
            int r = Integer.parseInt(arrRut[0]);

            String nom_com = consultar("//detalleConsulta/razon", doc);
            String status = consultar("//status", doc);
            if (status.equals("8") ){
                json = new JSONObject();
                json.put("rut", r);
                json.put("dv", arrRut[1]);
                json.put("nombre", consultar("//detalleConsulta/razon", doc));
                return json;
            }
            return null;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    public static void main(String[] args) {
//        bnsInformacion bn = new bnsInformacion();
//        //bn.obtenerInformacion("23847421-3", u);
//        bn.obtenerInformacion("74077300-3");
////        bn.obtenerInformacion("10090289-3", u);
////        bn.obtenerInformacion("19005052-1", u);
//    }
}
