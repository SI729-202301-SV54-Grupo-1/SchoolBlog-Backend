package pe.edu.upc.schoolblog.marks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.schoolblog.evaluation.domain.model.entity.Evaluation;
import pe.edu.upc.schoolblog.marks.domain.entity.Mark;
import pe.edu.upc.schoolblog.marks.domain.persistence.MarkRepository;
import pe.edu.upc.schoolblog.marks.domain.service.MarkService;
import pe.edu.upc.schoolblog.marks.resource.MarkResource;
import pe.edu.upc.schoolblog.student.domain.model.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;




    @Transactional(readOnly = true)
    @Override
    public List<Mark> fetchAll() {
        return markRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Mark> fetchById(Integer id) {

       if(markRepository.existsById(id))
        return markRepository.findById(id);
       else return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mark> fetchByStudent(Student student) {
        return markRepository.findByStudent(student);
    }

    @Transactional
    @Override
    public List<Mark> fetchByEvaluation(Evaluation evaluation) {
        return markRepository.findByEvaluation(evaluation);
    }

    @Transactional
    @Override
    public Mark save(Mark mark) {
        return markRepository.save(mark);
    }
    @Transactional
    @Override
    public Mark update(Mark mark) {
        return markRepository.save(mark);
    }

    @Transactional
    @Override
    public Boolean deleteById(Integer id) {

        if (markRepository.existsById(id)){
            markRepository.deleteById(id);
            return true;

        }
        return false;
    }
}
