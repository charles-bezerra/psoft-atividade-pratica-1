package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import interfaces.Repository;
import interfaces.ServiceRelation;
import models.Allotment;
import models.Product;

public class AllotmentService implements ServiceRelation {
    Repository<Integer, Allotment> repository;

    public AllotmentService(Repository<Integer, Allotment> repository) {
        this.repository = repository;
    }

    public Collection<Allotment> getAll() {
        return repository.all();
    }

    public void create(Product product, Integer amount, String expiretionDate) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        repository.add(new Allotment(product, amount, expiretionDate));
    }

    public Collection<Allotment> searchForProductName(String name) {
        Collection<Allotment> result = new ArrayList<>();
        Iterator<Allotment> iterator = repository.all().iterator();

        Allotment allotment = null;

        while (iterator.hasNext()) {
            allotment = iterator.next();
            if (allotment.getProduct().getName().matches(name))
                result.add(allotment);
        }

        return result;
    }

    public Collection<Allotment> search(Product product) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Collection<Allotment> result = new ArrayList<>();
        Iterator<Allotment> iterator = repository.all().iterator();
        Allotment aux;

        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getProduct().getId().equals(product.getId()))
                result.add(aux);
        }

        return result;
    }

    private Allotment search(Product product, Integer amount, String expiretionDate) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Allotment result = null;
        Allotment aux;
        Iterator<Allotment> iterator = repository.all().iterator();

        while (iterator.hasNext()) {
            aux = iterator.next();
            if (aux.getProduct().getId().equals(product.getId()) && aux.getAmount().equals(amount)
                    && aux.getExpirationDate().equals(expiretionDate)) {
                result = aux;
                break;
            }
        }

        return result;
    }

    public void remove(Product product, Integer amount, String expiretionDate) {
        if (product == null)
            throw new IllegalArgumentException("Argument product not can a null value");

        Allotment allotment = search(product, amount, expiretionDate);

        if (allotment == null)
            throw new IllegalArgumentException("Allotment not found in repository");

        repository.remove(allotment.getId());
    }

    @Override
    public void remove(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Argument object not can a null value");

        if (object.getClass() != Product.class)
            throw new IllegalArgumentException("Argument has been of type models.Product");

        Collection<Allotment> allotments = search((Product) object);

        allotments.stream().forEach(allotment -> {
            repository.remove(allotment.getId());
        });
    }
}
