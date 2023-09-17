package com.N1.Atividade.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.N1.Atividade.enity.Cores;

@Repository
public interface CoresRespository extends JpaRepository<Cores, Integer> {

    public boolean existsByNcor(String ncor);

    public List<Cores> findByNcor(String ncor);

    @Query("select max(s.id) from Cores s")
    public Integer findMaxId();
  
}