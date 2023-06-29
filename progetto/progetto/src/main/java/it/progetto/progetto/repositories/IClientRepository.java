package it.progetto.progetto.repositories;

import it.progetto.progetto.entities.Brand;
import it.progetto.progetto.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IClientRepository extends JpaRepository<Client,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Client u SET u.address=?1, u.age=?2, u.creditCard=?3, u.firstName=?4, u.lastName=?5, u.password=?6, u.username=?7 WHERE u.idClient = ?8")
    public void updateClient(String address,int age,String creditCard,String firstName,String lastName,String password,String username, int idClient);

    @Query(value = "SELECT * from client WHERE id_client=:id",nativeQuery = true)
    Client findyClient(int id);

    Client findById(int id);

    @Query(value = """
            SELECT id_client from client where id_client =:numero
            """,nativeQuery = true)
    Integer findIdByN(int numero);
}
