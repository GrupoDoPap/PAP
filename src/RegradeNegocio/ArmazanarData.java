/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegradeNegocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import oracle.net.aso.d;

/**
 *
 * @author Sanches
 */
public class ArmazanarData {

    public String  getDataAtual() {
        Date d = new Date();
        d.getDate();
        return d.toString();
    }
}
