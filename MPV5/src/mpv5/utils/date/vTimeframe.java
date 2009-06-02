/*
 * 
 * 
 */

package mpv5.utils.date;

import java.util.Date;

/**
 *
 *  anti43
 */
public class vTimeframe {
    private Date start;
    private Date end;
    private long time;

    public vTimeframe(Date start, Date ende) {
        this.start = start; 
        this.end = ende;   
        this.time = end.getTime() - start.getTime();   
    }

    public vTimeframe(vDate von, vDate bis){
        this.start = von.date; 
        this.end = bis.date;   
        this.time = end.getTime() - start.getTime();   
    }

    public boolean contains(Date day) {
        return this.getEnd().equals(day) || this.getStart().equals(day) || (day.after(this.getStart()) && day.before(this.getEnd()));
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    /**
     *
     * @return The difference of start and end in millis
     */
    public long getTime() {
        return time;
    }
    
    @Override
    public String toString(){
     return start + " - " + end; 
    }
}
