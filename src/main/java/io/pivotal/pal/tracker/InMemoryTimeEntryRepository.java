package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private long timeEntryId = 1L;
    HashMap<Long, TimeEntry> hmap = new HashMap<>();


    public TimeEntry create(TimeEntry timeEntry) {
    long newId=timeEntryId++;
        timeEntry.setId(newId);
        hmap.put(newId, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        TimeEntry te = hmap.get(timeEntryId);
        if (te == null)
            return null;
         else
            return te;


    }
    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(hmap.values());
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry any) {
        if (hmap.get(timeEntryId)==null)
        {
            return null;
        }
        else {
            System.out.println(any.getId());
            any.setId(timeEntryId);
            hmap.replace(timeEntryId, any);
            return hmap.get(timeEntryId);
        }
    }

    @Override
    public void delete(long timeEntryId) {
        if(hmap.get(timeEntryId)!=null)
        hmap.remove(timeEntryId);

    }


}
