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

package mp3.classes.interfaces;

import java.io.File;

/**
 *
 * @author anti
 */
public interface Structure {
    
    



    
    /**
     * Eigene Daten
     */
    public final String TABLE_MYDATA = "daten";
    /**
     * Kundendaten
     */
    public final String TABLE_CUSTOMERS = "kunden";
    /**
     * Kundendaten
     */
    public final String TABLE_MANUFACTURER = "hersteller";
    /**
     * Kundendaten
     */
    public final String TABLE_SUPPLIER = "lieferanten";
    /**
     * Produktdaten
     */
    public final String TABLE_PRODUCTS = "produkte";
    /**
     * Rechnungsdaten
     */
    public final String TABLE_BILLS = "rechnungen";
    /**
     * Rechnungsposten
     */
    public final String TABLE_BILLS_DATA = "rechnungsposten";
    /**
     * Auftragsdaten
     */
    public final String TABLE_ORDERS = "auftraege";
    /**
     * Auftragsposten
     */
    public final String TABLE_ORDERS_DATA = "auftragsposten";
    /**
     * Files (pictures) of products
     */
    public final String TABLE_PRODUCTS_FILES = "dateien";
    /**
     * History
     */
    public final String TABLE_HISTORY = "historie";
    
     /**
     * User
     */
    public final String TABLE_USER = "usertable";
    /**
     * Productgroups
     */
    public final String TABLE_PRODUCTS_GROUPS_CATEGORIES = "warengruppenkategorien"; 
    public final String TABLE_PRODUCTS_GROUPS_FAMILIES = "warengruppenfamilien";
    public final String TABLE_PRODUCTS_GROUPS_GROUPS = "warengruppengruppen";
    
     /**
     * Kontenrahmen
     */
    public final String TABLE_KONTEN = "konten";
     /**
     * Ausgaben
     */
    public final String TABLE_DUES = "ausgaben";
    
    /**
     * Einnahmen
     */
    public final String TABLE_INCOME = "einnahmen";
   
  
    public final String TABLE_CUSTOMER_PRINT_FIELDS =
            "Kundennummer" + "," + "Firma" + "," + "Anrede" + "," + "Vorname" +
            "," + "Name" + "," + "Str" + "," + "PLZ" + "," + "Ort" + "," +
            "Tel" +"," + "Fax" + "," + "Mobil" + "," + "Mail" + "," + "Webseite";
     
     

     /**
     * Fields in customer table
     */
    public final String TABLE_CUSTOMER_FIELDS =
            "Kundennummer" + "," + "Firma" + "," + "Anrede" + "," + "Vorname" +
            "," + "Name" + "," + "Str" + "," + "PLZ" + "," + "Ort" + "," +
            "Tel" +"," + "Fax" + "," + "Mobil" + "," + "Mail" + "," + "Webseite" + "," + "Notizen";
    /**
     * Fields in supplier table
     */
    public final String TABLE_SUPPLIER_FIELDS =
            "Lieferantennummer" + "," + "Firma" + "," + "Str" + "," + "PLZ" + "," + "Ort" + "," +
            "Tel" +"," + "Fax" +  "," + "Mobil" + "," + "Mail" + "," + "Webseite" + "," + "Notizen";
      /**
     * Fields in supplier table
     */
    public final String TABLE_SUPPLIER_PRINT_FIELDS =
            "Lieferantennummer" + "," + "Firma" + "," + "Str" + "," + "PLZ" + "," + "Ort" + "," +
            "Tel" +"," + "Fax" +  "," + "Mobil" + "," + "Mail" + "," + "Webseite";
 
    
     /**
     * Fields in manufacturer table
     */
    public final String TABLE_MANUFACTURER_FIELDS =
            "Herstellernummer" + "," + "Firma" + "," + "Anrede" + "," + "Vorname" +
            "," + "Name" + "," + "Str" + "," + "PLZ" + "," + "Ort" + "," +
            "Tel" +"," + "Fax" +  "," + "Mobil" + "," + "Mail" + "," + "Webseite" + "," + "Notizen";
    
     /**
     * Fields in bills data table
     */
     public final String TABLE_BILLS_DATA_FIELDS =
             "Rechnungid" + "," + "Anzahl" + ","+
             
             "Posten" + "," +"Preis" + "," +
             "Steuersatz";
     /**
     * Fields in bills table
     */
     public final String TABLE_BILLS_FIELDS =
              "Rechnungnummer" + "," +"KundenId" + "," +
              "Datum" + "," + "Storno" + "," + "bezahlt"+ "," + "gesamtpreis"+ "," + "gesamttax";
        
          /**
     * Fields in orders data table
     */
     public final String TABLE_ORDERS_DATA_FIELDS =
             "Auftragid" + "," + "Anzahl" + ","+
             
             "Posten" + "," +"Preis" + "," +
             "Steuersatz";
     /**
     * Fields in orders table
     */
     public final String TABLE_ORDERS_FIELDS =
              "Auftragnummer" + "," +"KundenId" + "," +
              "Datum"+ "," +"auftrag"+ "," +"bis"+ "," +"rechnung";
     
      /**
     * Fields in mydata table
     */
     public final String TABLE_MYDATA_FIELDS =
              "name" + "," +"wert" ;
     /**
     * Fields in products table
     */
     public final String TABLE_PRODUCTS_FIELDS =
              "Produktnummer" + "," +"Name" + "," + "Text" + "," +"VK" + "," +"EK" +
              "," +"Tax"+ ","+ "hersteller"+ ","+"lieferantenid"+ ","+"warengruppenid"
              
              + ","+"Datum"+ ","+"Url" + "," + "EAN";
       
//     /**
//     * Fields in products groups table
//     */
//     public final String TABLE_PRODUCTS_GROUPS_FIELDS =
//               "Warengruppennummer" + "," +"Name";
     
    /**
     * Fields in products groups categories table
     */
     public final String TABLE_PRODUCTS_GROUPS_CATEGORIES_FIELDS =
               "kategorienummer"+","+"name";
         /**
     * Fields in products groups family table
     */
     public final String TABLE_PRODUCTS_GROUPS_FAMILY_FIELDS =
               "familienummer"+","+"kategorieid"+","+"name";
         /**
     * Fields in products groups group table
     */
     public final String TABLE_PRODUCTS_GROUPS_GROUP_FIELDS =
               "gruppenummer"+","+"familienid"+","+"name";
     
     /**
     * Fields in products files table
     */
     public final String TABLE_PRODUCTS_FILES_FIELDS =
               "productid" + "," +"url"+ ","+ "datum";
     
    /**
     * Fields in history table
     */
     public final String TABLE_HISTORY_FIELDS =
               "aktion" + "," +"text"+ ","+ "datum";
     
     /**
     * User table
     */
     public final String TABLE_USER_FIELDS=
               "username" + "," +"password";
     
     /**
     * Columns for productslist table
     */
     public final String TABLE_PRODUCTS_LIST_COLUMNS =
              "Produktnummer" + "," +"Name" + "," + "Text" + "," +"VK" + "," +"EK" +
              "," +"Tax"+ ","+ "Herstellernummer"+ ","+"Lieferantennummer"+ ","+"Warengruppennummer"
              
              + ","+"Datum"+ ","+"Url" + "," + "EAN";
     
  /**
     * Kontenrahmen
     */
    public final String TABLE_KONTEN_FIELDS = "nummer" + "," +"klasse" + "," +"gruppe" + "," +"art";
    
    
    
     /**
     * Ausgaben
     */
    public final String TABLE_OUTGOINGS_FIELDS = "kontenid" + "," +"beschreibung" + "," +
            "preis" + "," +"tax" + "," +"datum";
    
    /**
     * Einnahmen
     */
    public final String TABLE_INCOME_FIELDS  = "kontenid" + "," +"beschreibung" + "," +
            "preis" + "," +"tax" + "," +"datum";
     
     /**
      * 
      * String utilitis
      */
     public final String ALL = "*";
     public final String NULL = "";
     public final String ID = "id";
     public final String NOTNULL = "NOT null";
     
     public final String CUSTOMER = "Kunde";

     
     public final String SUPPLIER = "Lieferant";

     
     public final String PRODUCT = "Produkt";
  
     
     public final String ORDER = "Angebot";

     
     public final String BILL = "Rechnung";
     
     public final String BACKUP = "Datensicherung";
     
     public final String KONTEN = "Konten";

   
}