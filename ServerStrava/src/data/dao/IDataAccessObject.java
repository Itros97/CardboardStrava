package data.dao;

import java.util.List;

//This interface defines the basic methods of Data Access Object Pattern
//This interface uses the concept of a "template".
//Classes implementing it must specify the concrete type on which the methods are applied.
public interface IDataAccessObject<DomainObject> {
    void save(DomainObject object);
    void delete(DomainObject object);
    List<DomainObject> getAll();
    DomainObject find(String param);
}
