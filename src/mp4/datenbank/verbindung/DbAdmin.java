/*
 * 
 *  *  This file is part of MP by anti43 /GPL.
 *  *  
 *  *      MP is free software: you can redistribute it and/or modify
 *  *      it under the terms of the GNU General Public License as published by
 *  *      the Free Software Foundation, either version 3 of the License, or
 *  *      (at your option) any later version.
 *  *  
 *  *      MP is distributed in the hope that it will be useful,
 *  *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 * *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *      GNU General Public License for more details.
 *  *  
 *  *      You should have received a copy of the GNU General Public License
 *  *      along with MP.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */

package mp4.datenbank.verbindung;

import mp4.globals.Constants;
import mp4.globals.Constants;
import mp4.globals.Strings;
import mp4.datenbank.verbindung.ConnectionHandler;
import mp3.classes.layer.Things;

/**
 *
 * @author anti43
 */
public class DbAdmin extends Things implements Strings, Constants{

    public DbAdmin(){
        super(ConnectionHandler.instanceOf());
    
    }
    
    public void clearTable(String table){
    
    this.freeQuery("DELETE FROM " + table);
    
    }
    


}