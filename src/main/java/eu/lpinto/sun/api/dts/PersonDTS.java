package eu.lpinto.sun.api.dts;

import eu.lpinto.universe.api.dts.AbstractDTS;
import eu.lpinto.universe.api.dts.AbstractDTS;
import eu.lpinto.sun.persistence.entities.Person;

/**
 * Person DTO - Data Transformation Object
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
public class PersonDTS extends AbstractDTS<Person, eu.lpinto.sun.api.dto.Person> {

    public static final PersonDTS T = new PersonDTS();

    @Override
    public eu.lpinto.sun.api.dto.Person toAPI(Person entity) {
        if (entity == null) {
            return null;

        }
        else if (entity.isFull()) {
            return new eu.lpinto.sun.api.dto.Person(
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getMobilePhone(),
                    entity.getStreet(),
                    entity.getTown(),
                    entity.getCountry(),
                    entity.getZip(),
                    entity.getNif(),
                    EmployeeDTS.T.ids(entity.getOrganizations()),
                    entity.getId(), entity.getName(), entity.getCreated(), entity.getUpdated());

        }
        else {
            return new eu.lpinto.sun.api.dto.Person(
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getMobilePhone(),
                    entity.getStreet(),
                    entity.getTown(),
                    entity.getCountry(),
                    entity.getZip(),
                    entity.getNif(),
                    null,
                    entity.getId(), entity.getName(), entity.getCreated(), entity.getUpdated());
        }
    }

    @Override
    public Person toDomain(Long id) {
        if (id == null) {
            return null;
        }

        return new Person(id);
    }

    @Override
    public Person toDomain(eu.lpinto.sun.api.dto.Person dto) {
        return new Person(
                dto.getEmail(),
                dto.getPhone(),
                dto.getMobilePhone(),
                dto.getStreet(),
                dto.getTown(),
                dto.getCountry(),
                dto.getZip(),
                dto.getNif(),
                EmployeeDTS.T.toDomainIDs(dto.getOrganizations()),
                dto.getId(), dto.getName(), dto.getCreated(), dto.getUpdated());
    }
}
