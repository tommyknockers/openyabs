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
package mp4.utils.export.pdf;

import java.awt.Image;
import mp4.items.Kunde;
import mp4.items.Rechnung;


import java.io.*;
import java.util.ArrayList;

import mp4.interfaces.Template;
import mp4.items.visual.Popup;
import mp4.einstellungen.Einstellungen;
import mp4.einstellungen.Programmdaten;
import mp4.utils.files.PDFFile;
import mp4.utils.listen.ListenDataUtils;
import mp4.utils.zahlen.FormatNumber;

/**
 *
 * @author anti43
 */
public class PDF_Lieferschein implements Template {

    private Einstellungen l;
    private Rechnung rechnung;
    private Kunde k;
    private Object[][] products;
    private Double netto = 0d;
    private Double brutto = 0d;
    private ArrayList fields = new ArrayList();
    private String path;

    /**
     * 
     * @param bill 
     */
    public PDF_Lieferschein(Rechnung bill, boolean persistent) {
        l = Einstellungen.instanceOf();
        this.rechnung = bill;
        k = new Kunde(bill.getKundenId());
        products = rechnung.getProductlistAsArray();

        if (persistent) {
            path = getTargetFile().getPath();
        } else {
            path = PDFFile.getTempFilename() + ".pdf".trim();
        }
    }

    @SuppressWarnings("unchecked")
    private String[][] buildFieldList() {

        if (Programmdaten.instanceOf().getBILLPANEL_CHECKBOX_MITFIRMENNAME_state()) {
            fields.add(new String[]{"company", k.getFirma()});
        }
        fields.add(new String[]{"name", k.getAnrede() + " " + k.getVorname() + " " + k.getName()});
        fields.add(new String[]{"street", k.getStr()});
        fields.add(new String[]{"city", k.getPLZ() + " " + k.getOrt()});
        fields.add(new String[]{"date", rechnung.getFDatum()});
        fields.add(new String[]{"number", rechnung.getRechnungnummer()});
        fields.add(new String[]{"knumber", k.getNummer()});

        for (int i = 0; i < products.length; i++) {
            int t = i + 1;
            try {
                if (products[i][2] != null && String.valueOf(products[i][2]).length() > 0) {
                    fields.add(new String[]{"count" + t, t + "."});
                    fields.add(new String[]{"quantity" + t, FormatNumber.formatDezimal((Double) products[i][1])});
                    fields.add(new String[]{"product" + t, String.valueOf(products[i][2])});
                }
            } catch (Exception exception) {
                Popup.notice(this, exception.getMessage());
            }
        }


        return ListenDataUtils.StringListToTableArray(fields);
    }

    @Override
    public String getPath() {
        return path;
    }

    public String[][] getFields() {
        return buildFieldList();
    }

    public Image getImage() {
        return null;
    }

    public String getTemplate() {
        return l.getLieferschein_Template();
    }

    @Override
    public File getTargetFile() {
        return new File(l.getLieferschein_Verzeichnis() + File.separator +
                "Lieferschein-" + rechnung.getRechnungnummer().replaceAll(" ", "_") + "_" + k.getFirma().replaceAll(" ", "_") + "_" + k.getName().replaceAll(" ", "_") + ".pdf");
    }
}
