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

import mp3.classes.utils.Log;
import handling.db.Query;



 /**
 * @author anti43         
 */
public class ProductGroupFamily extends mp3.classes.layer.Things implements mp4.datenbank.struktur.Tabellen {

    private String familiennummer = "0";
    private Integer kategorieID = 0;
    private String name = "";
      
    private String[][] data;
    private Query query;
   public Integer id = 0;
    public Integer getId() {
        return id;
    }
    public void destroy() {
        this.delete(this.id);
        this.id = 0;
    }
    public ProductGroupFamily(Query query) {
        super(query.clone(TABLE_PRODUCTS_GROUPS_FAMILIES));

    }
    
    public ProductGroupFamily(Query query, String id) {
        super(query.clone(TABLE_PRODUCTS_GROUPS_FAMILIES));
        
        this.id=Integer.valueOf(id);
        this.explode(this.selectLast("*", "id", id, true , true, false));
        this.query=query;
    }

    /**
     * 
     * @return
     */
    public int getID() {
       return id;
    }

    @Override
  public String toString(){
  return this.name;
  
  }
  
    private void explode(String[] data) {
        try {
            this.id = Integer.valueOf(data[0]);
            this.setFamiliennummer(data[1]);
            this.setKategorieid(Integer.valueOf(data[2]));
            this.setName(data[3]);
        } catch (NumberFormatException numberFormatException) {
            Log.Debug(numberFormatException);
        }
        
//        Log.Debug("exp"+data[2]);
        
    }


    private String collect() {
        String str = "";
        str= str + "(;;2#4#1#1#8#0#;;)"+getFamiliennummer()+"(;;2#4#1#1#8#0#;;)"+"(;;,;;)";
        str =str + getKategorieid() + "(;;,;;)";
        str = str + "(;;2#4#1#1#8#0#;;)"+getName()+"(;;2#4#1#1#8#0#;;)";
      
        return str;
    }

    public void save() {

        if (id > 0) {
            this.update(TABLE_PRODUCTS_GROUPS_FAMILY_FIELDS, this.collect(), id.toString());
            isSaved = true;
        } else if (id == 0) {
             if(this.getFamiliennummer().equals("0")){
            
                this.setFamiliennummer((this.getNextIndex("familienummer").toString()));
            }
            id = this.insert(TABLE_PRODUCTS_GROUPS_FAMILY_FIELDS, this.collect());
        } else {

        }
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public String getFamiliennummer() {
        return familiennummer;
    }

    public void setFamiliennummer(String familiennummer) {
        this.familiennummer = familiennummer;
    }

    public Integer getKategorieid() {
        return kategorieID;
    }

    public void setKategorieid(Integer kategorieid) {
        this.kategorieID = kategorieid;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public Integer getKategorieID(){
    
       return Integer.valueOf(this.getKategorieid());
    }
  
}