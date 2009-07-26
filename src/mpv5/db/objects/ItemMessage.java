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
package mpv5.db.objects;

import java.util.ArrayList;
import javax.swing.JComponent;

import mpv5.db.common.Context;
import mpv5.db.common.DatabaseObject;
import mpv5.db.common.NodataFoundException;
import mpv5.db.common.QueryHandler;

/**
 *
 *  Messages to be printed on Bills etc
 */
public class ItemMessage extends DatabaseObject {

    public ItemMessage() {
        context.setDbIdentity(Context.IDENTITY_MESSAGES);
        context.setIdentityClass(this.getClass());
    }

    @Override
    public JComponent getView() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get all Items which are assigned to this message
     * @return
     * @throws mpv5.db.common.NodataFoundException
     */
    public ArrayList<Item> getItemsWithMessage() throws NodataFoundException {
        ArrayList<Item> tmp = DatabaseObject.getReferencedObjects((Item) DatabaseObject.getObject(Context.getItems()), Context.getMessagesToItems());
        
        return tmp;
    }

    /**
     * Get all messages where the given item is currently assigned to
     * @param item
     * @return
     * @throws mpv5.db.common.NodataFoundException
     */
    public static ArrayList<ItemMessage> getMessagesOfItem(Item item) throws NodataFoundException {
        Object[][] tmp = QueryHandler.instanceOf().clone(Context.getMessagesToItems()).select("messagesids", new String[]{"itemsids", item.__getIDS().toString(), ""});
        ArrayList<ItemMessage> l = new ArrayList<ItemMessage>();

        for (int i = 0; i < tmp.length; i++) {
            int id = Integer.valueOf(tmp[i][0].toString());
            l.add((ItemMessage) DatabaseObject.getObject(Context.getMessages(), id));
        }

        return l;
    }

  @Override
    public mpv5.utils.images.MPIcon getIcon() {
        return null;
    }
}
