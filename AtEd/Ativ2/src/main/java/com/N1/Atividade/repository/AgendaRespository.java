package com.N1.Atividade.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.N1.Atividade.enity.Agenda;

@Repository
public interface AgendaRespository extends JpaRepository<Agenda, Integer> {

    public boolean existsByNome(String Nome);

    public List<Agenda> findByNome(String Contato);

    @Query("select max(s.id) from Agenda s")
    public Integer findMaxId();
  
}