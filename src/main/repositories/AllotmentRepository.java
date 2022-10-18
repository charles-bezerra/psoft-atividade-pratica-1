package repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import interfaces.Repository;
import models.Allotment;

public class AllotmentRepository implements Repository<Integer, Allotment> {
    Map<Integer, Allotment> allotments;

    public AllotmentRepository() {
        this.allotments = new HashMap<>();
    }

    public Allotment get(Integer id) {
        return allotments.get(id);
    }

    public Collection<Allotment> all() {
        return allotments.values();
    }

    public void add(Allotment allotment) {
        allotments.put(allotment.getId(), allotment);
    }

    public void remove(Integer id) {
        Allotment al = allotments.remove(id);

        if (al == null)
            throw new IllegalArgumentException("Allotment not found in repositories.AllotmentRepository");
    }
}
