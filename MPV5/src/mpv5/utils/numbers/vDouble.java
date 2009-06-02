/*
 *  This file is part of MP.
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
package mpv5.utils.numbers;

import mpv5.utils.numberformat.NumberCheck;



/**
 *
 *  anti
 */
public class vDouble{

    public Double value = null;
    public String svalue = null;
    public boolean isVerified = false;
    public boolean isPositive = false;
    public String ovalue = "";

    public vDouble(Object number) {
        if (number != null) {
            this.ovalue = number.toString();
            if (NumberCheck.checkDouble(number) != null) {

                this.value = NumberCheck.checkDouble(number);
                this.svalue = this.value.toString();
                this.isVerified = true;

                if (this.value >= 0) {
                    this.isPositive = true;
                }
            }
        }
    }
}
