/*
 *  This file is part of MP by anti43 /GPL.
 *  
 *      MP is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *  
 *      MP is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *  
 *      You should have received a copy of the GNU General Public License
 *      along with MP.  If not, see <http://www.gnu.org/licenses/>.
 */
package mp4.klassen.objekte;

import handling.db.Query;
import mp3.classes.layer.Popup;
import mp3.classes.utils.Log;

/**
 *
 * @author anti43
 */
public class RechnungPosten extends mp3.classes.layer.Things implements mp4.datenbank.struktur.Tabellen {

    private Integer rechnungid = null;
    private Double anzahl = 0.0;
    private String posten = "";
    private Double preis = 0.0;
    private Double steuersatz = 0.0;
   public Integer id = 0;
    public Integer getId() {
        return id;
    }
    public void destroy() {
        this.delete(this.id);
        this.id = 0;
    }
    public RechnungPosten(Query query) {
        super(query.clone(TABLE_BILLS_DATA));

    }

    /**
     * 
     * @param query
     * @param id
     */
    public RechnungPosten(Query query, String id) {
        super(query.clone(TABLE_BILLS_DATA));
        this.id = Integer.valueOf(id);
        this.explode(this.selectLast("*", "id", id, true));
    }

    private void explode(String[] select) {

        try {
            this.setRechnungid(Integer.valueOf(select[1]));
            this.setAnzahl(Double.valueOf(select[2]));
            this.setPosten(select[3]);
            this.setPreis(Double.valueOf( select[4]));
            this.setSteuersatz(Double.valueOf( select[5]));
        } catch (NumberFormatException numberFormatException) {
            Log.Debug(numberFormatException);
        }
    }


    private String collect() {
        String str = "";
        str = str +  this.getRechnungid() + "(;;,;;)";
        str = str +  this.getAnzahl()  + "(;;,;;)";
        str = str + "(;;2#4#1#1#8#0#;;)" + this.getPosten() + "(;;2#4#1#1#8#0#;;)" + "(;;,;;)";
        str = str +  this.getPreis() +   "(;;,;;)";
        str = str +  this.getSteuersatz();
        
//        str = str + "'" + "null" + "'" + ",";
//        str = str + "'" + "null" + "'" + ",";
//        str = str + "'" + "null" + "'";
        
        return str;
    }

    public void save() {

        if (id > 0) {
            this.update(TABLE_BILLS_DATA_FIELDS, this.collect(), id.toString());
            isSaved = true;
        } else if (id == 0) {
            this.insert(TABLE_BILLS_DATA_FIELDS, this.collect());
        } else {

            mp3.classes.layer.Popup.warn(java.util.ResourceBundle.getBundle("languages/Bundle").getString("no_data_to_save"), Popup.WARN);

        }
    }

    public Integer getRechnungid() {
        return rechnungid;
    }

    public void setRechnungid(Integer rechnungid) {
        this.rechnungid = rechnungid;
    }

    public String getPosten() {
        return posten;
    }

    public void setPosten(String posten) {
        this.posten = posten;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double  preis) {
        this.preis = preis;
    }

    public Double  getSteuersatz() {
        return steuersatz;
    }

    public void setSteuersatz(Double  steuersatz) {
        this.steuersatz = steuersatz;
    }

    public Double  getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Double  anzahl) {
        this.anzahl = anzahl;
    }

}