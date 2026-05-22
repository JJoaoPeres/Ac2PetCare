package com.example.atividade4;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade4.models.Animal;
import com.example.atividade4.models.Consulta;
import com.example.atividade4.models.Prontuario;
import com.example.atividade4.models.Tutor;
import com.example.atividade4.models.Vacina;
import com.example.atividade4.models.Veterinario;
import com.example.atividade4.repositories.AnimalRepository;
import com.example.atividade4.repositories.ConsultaRepository;
import com.example.atividade4.repositories.ProntuarioRepository;
import com.example.atividade4.repositories.TutorRepository;
import com.example.atividade4.repositories.VacinaRepository;
import com.example.atividade4.repositories.VeterinarioRepository;

@SpringBootApplication
public class Atividade4Application {

    @Bean
    public CommandLineRunner init(
            @Autowired TutorRepository tutorRepository,
            @Autowired AnimalRepository animalRepository,
            @Autowired VeterinarioRepository veterinarioRepository,
            @Autowired ConsultaRepository consultaRepository,
            @Autowired ProntuarioRepository prontuarioRepository,
            @Autowired VacinaRepository vacinaRepository) {

        return args -> {

            System.out.println("*** INSERINDO TUTORES ***");

            Tutor tutor1 = Tutor.builder()
                    .nome("Carlos Silva")
                    .cpf("123.456.789-00")
                    .telefone("(15) 99999-9999")
                    .endereco("Rua das Flores, 123 - Sorocaba/SP")
                    .build();

            Tutor tutor2 = Tutor.builder()
                    .nome("Mariana Souza")
                    .cpf("987.654.321-00")
                    .telefone("(15) 98888-8888")
                    .endereco("Avenida Brasil, 500 - Sorocaba/SP")
                    .build();

            tutor1 = tutorRepository.save(tutor1);
            tutor2 = tutorRepository.save(tutor2);

            System.out.println("*** INSERINDO ANIMAIS ***");

            Animal animal1 = Animal.builder()
                    .nome("Mel")
                    .especie("Caninos")
                    .raca("Golden Retriever")
                    .dataNascimento(LocalDate.of(2020, 5, 10))
                    .tutor(tutor1)
                    .build();

            Animal animal2 = Animal.builder()
                    .nome("Mingau")
                    .especie("Felinos")
                    .raca("Siamês")
                    .dataNascimento(LocalDate.of(2021, 3, 15))
                    .tutor(tutor2)
                    .build();

            animal1 = animalRepository.save(animal1);
            animal2 = animalRepository.save(animal2);

            System.out.println("*** INSERINDO VETERINÁRIOS ***");

            Veterinario veterinario1 = Veterinario.builder()
                    .nome("Dra. Ana Souza")
                    .crmv("CRMV-SP 12345")
                    .especializacao("Caninos")
                    .build();

            Veterinario veterinario2 = Veterinario.builder()
                    .nome("Dr. Pedro Lima")
                    .crmv("CRMV-SP 54321")
                    .especializacao("Felinos")
                    .build();

            veterinario1 = veterinarioRepository.save(veterinario1);
            veterinario2 = veterinarioRepository.save(veterinario2);

            System.out.println("*** INSERINDO CONSULTAS ***");

            Consulta consulta1 = Consulta.builder()
                    .local("Sala 01")
                    .data(LocalDate.of(2026, 5, 22))
                    .hora(LocalTime.of(14, 30))
                    .animal(animal1)
                    .veterinario(veterinario1)
                    .build();

            Consulta consulta2 = Consulta.builder()
                    .local("Sala 02")
                    .data(LocalDate.of(2026, 5, 23))
                    .hora(LocalTime.of(10, 0))
                    .animal(animal2)
                    .veterinario(veterinario2)
                    .build();

            consultaRepository.save(consulta1);
            consultaRepository.save(consulta2);

            System.out.println("*** INSERINDO PRONTUÁRIOS ***");

            Prontuario prontuario1 = Prontuario.builder()
                    .dataAtendimento(LocalDate.of(2026, 5, 22))
                    .observacoes("Animal apresentou febre e falta de apetite.")
                    .animal(animal1)
                    .veterinario(veterinario1)
                    .build();

            Prontuario prontuario2 = Prontuario.builder()
                    .dataAtendimento(LocalDate.of(2026, 5, 23))
                    .observacoes("Animal apresentou melhora após tratamento anterior.")
                    .animal(animal2)
                    .veterinario(veterinario2)
                    .build();

            prontuarioRepository.save(prontuario1);
            prontuarioRepository.save(prontuario2);

            System.out.println("*** INSERINDO VACINAS ***");

            Vacina vacina1 = Vacina.builder()
                    .nome("Antirrábica")
                    .dataAplicacao(LocalDate.of(2026, 5, 22))
                    .dataProximaDose(LocalDate.of(2027, 5, 22))
                    .observacoes("Vacina aplicada sem reações.")
                    .animal(animal1)
                    .build();

            Vacina vacina2 = Vacina.builder()
                    .nome("V4 Felina")
                    .dataAplicacao(LocalDate.of(2026, 5, 23))
                    .dataProximaDose(LocalDate.of(2027, 5, 23))
                    .observacoes("Vacina aplicada com sucesso.")
                    .animal(animal2)
                    .build();

            vacinaRepository.save(vacina1);
            vacinaRepository.save(vacina2);

            System.out.println("*** DADOS INSERIDOS COM SUCESSO ***");

            System.out.println("\n*** LISTANDO ANIMAIS ***");
            animalRepository.findAll().forEach(a -> System.out.println(
                    "Animal: " + a.getNome()
                            + " | Espécie: " + a.getEspecie()
                            + " | Tutor: " + a.getTutor().getNome()
            ));

            System.out.println("\n*** LISTANDO VETERINÁRIOS ***");
            veterinarioRepository.findAll().forEach(v -> System.out.println(
                    "Veterinário: " + v.getNome()
                            + " | CRMV: " + v.getCrmv()
                            + " | Especialização: " + v.getEspecializacao()
            ));

            System.out.println("\n*** LISTANDO CONSULTAS ***");
            consultaRepository.findAll().forEach(c -> System.out.println(
                    "Consulta ID: " + c.getId()
                            + " | Animal: " + c.getAnimal().getNome()
                            + " | Veterinário: " + c.getVeterinario().getNome()
                            + " | Data: " + c.getData()
                            + " | Hora: " + c.getHora()
            ));

            System.out.println("\n*** LISTANDO VACINAS DO ANIMAL 1 ***");
            vacinaRepository.findByAnimalId(animal1.getId()).forEach(v -> System.out.println(
                    "Vacina: " + v.getNome()
                            + " | Aplicação: " + v.getDataAplicacao()
                            + " | Próxima dose: " + v.getDataProximaDose()
            ));

            System.out.println("\n*** LISTANDO PRONTUÁRIOS DO ANIMAL 1 ***");
            prontuarioRepository.findByAnimalId(animal1.getId()).forEach(p -> System.out.println(
                    "Data: " + p.getDataAtendimento()
                            + " | Observações: " + p.getObservacoes()
                            + " | Veterinário: " + p.getVeterinario().getNome()
            ));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Atividade4Application.class, args);
    }
}