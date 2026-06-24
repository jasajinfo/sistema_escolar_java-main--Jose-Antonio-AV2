Sistema Escolar Java — README de Erros Encontrados e Correções Este documento explica os principais erros encontrados no projeto "sistema_escolar_java-main-Jose Antônio AV2":

1.Busca de aluno na matrícula convertendo ID para "string"

Arquivo: src/main/java/com/github/app/controller/MatriculaController.java

Erro encontrado:

Aluno aluno = alunoRepository.getReferenceById(dados.alunoId().toString());

Deveria ser:

Aluno aluno = alunoRepository.getReferenceById(dados.alunoId());

O ID do aluno é Integer, mas estava sendo convertido para "String". Isso ocorre porque o "AlunoRepository" também estava configurado incorretamente com "String".

2.Cadastro de professor sem "@Transactional"

Arquivo: src/main/java/com/github/app/controller/ProfessorController.java

Erro encontrado:

@PostMapping public void cadastrar(@RequestBody DadosCadastroProfessor dados) { repository.save(new Professor(dados)); }

Deveria ser:

@PostMapping @Transactional public void cadastrar(@RequestBody DadosCadastroProfessor dados) { repository.save(new Professor(dados)); }

O método de cadastro não estava anotado com "@Transactional". Embora o "repository.save()" possa funcionar em muitos casos, o ideal é manter a transação explícita nos métodos que alteram o banco, seguindo o padrão usado nos demais controllers.

3.Entidade "aluno" mapeada para a tabela errada

Arquivo: src/main/java/com/github/app/model/aluno/Aluno.java

Erro encontrado:

@Table(name = "professores")

Deveria ser

@Table(name = "alunos")

A entidade "Aluno" estava usando a tabela "professores". Com isso, os registros de alunos seriam gravados ou consultados na tabela errada, misturando dados de alunos com dados de professores.

4."DadosListagemAluno" com nome e e-mail invertidos

Arquivo: src/main/java/com/github/app/model/aluno/DadosListagemAluno.java

Erro encontrado:

public DadosListagemAluno(Aluno aluno) { this( aluno.getId(), aluno.getEmail(), aluno.getNome(), aluno.getRa(), aluno.getCurso() ); }

Deveria ser:

public DadosListagemAluno(Aluno aluno) { this( aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getRa(), aluno.getCurso() ); }

O campo "nome" recebia o e-mail e o campo "email" recebia o nome. A listagem de alunos ficava trocada.

5.Dois endpoints "POST" iguais em "AlunoController"

Arquivo: src/main/java/com/github/app/controller/AlunoController.java

Erro encontrado:

@PostMapping @Transactional public void cadastrar(@RequestBody DadosCadastroAluno dados) { repository.save(new Aluno(dados)); } @PostMapping @Transactional public void atualizar(@RequestBody DadosAtualizacaoAluno dados) { var aluno = repository.getReferenceById(dados.id()); aluno.atualizarInformacoes(dados); }

Deveria ser:

@PostMapping @Transactional public void cadastrar(@RequestBody DadosCadastroAluno dados) { repository.save(new Aluno(dados)); } @PutMapping @Transactional public void atualizar(@RequestBody DadosAtualizacaoAluno dados) { var aluno = repository.getReferenceById(dados.id()); aluno.atualizarInformacoes(dados); }

O cadastro e a atualização usam o mesmo método HTTP e a mesma rota.O Spring Boot não consegue diferenciar qual método deve executar.

6.Atualização de professor gravando e-mail no campo "nome" Arquivo:

src/main/java/com/github/app/model/professor/Professor.java

Erro encontrado:

if (dados.email() != null) { this.nome = dados.email(); }

Deveria ser:

if (dados.email() != null) { this.email = dados.email(); }

Ao atualizar o e-mail do professor, o sistema alterava o campo "nome", e não o campo "email".

7.Exclusão de aluno usando "String" no "@PathVariable"

Arquivo:

src/main/java/com/github/app/controller/AlunoController.java

Erro encontrado:

@DeleteMapping("/{id}") @Transactional public void excluir(@PathVariable String id) { repository.deleteById(id); }

Deveria ser:

@DeleteMapping("/{id}") @Transactional public void excluir(@PathVariable Integer id) { repository.deleteById(id); }

O ID de "Aluno" é "Integer", mas o controller recebia "String". Isso também estava ligado ao erro do "AlunoRepository".

8."@PathVariable" da matrícula com nome incompatível

Arquivo: src/main/java/com/github/app/controller/MatriculaController.java

Erro encontrado:

@DeleteMapping("/{id}") @Transactional public void excluir(@PathVariable Integer ids) { repository.deleteById(ids); }

Deveria ser:

@DeleteMapping("/{id}") @Transactional public void excluir(@PathVariable Integer id) { repository.deleteById(id); }

A rota usa "id", mas o parâmetro do método se chama "ids". Dependendo da configuração do compilador, o Spring pode não conseguir associar automaticamente o valor da URL ao parâmetro.




## ANOTATIONS - ANOTAÇÕES
1. Anotações do Spring Web
`@RequestMapping("/medicos")`
=> Define que a classe está mapeada para a url[endpoint] /medicos.

`@RestController`
=> Define que a classe é uma classe controladora no Spring.

`@GetMapping` 
=> Define que o método será somente leitura.

`@PostMapping`
=> Define que o método irá receber dados.

`@PutMapping`
=> Atualiza alguma informação.

`@DeleteMapping`
=> Deleta dados.

`@ResquestBody`
=> é utilizada quando você irá receber dados pelo simulador de requisição [insomnia], e informa que os dados serão enviados no corpo da requisição.

`@Autowired`
=> é utilizado quando você está aplicando a injeção de depêndencia. Ou seja, o Springboot sabe o que a classe(interface) possui de métodos e atributos.

`@Transactional`
=> é utilizado para que o método consiga realizar algum tipo de modelagem(alteração) no BD.

## RELACIONAMENTO ENTRE TABELAS NO SPRINGBOOT
`@OneToOne` -> Um para um. (Uma consulta está ligada a um único médico).
`@OneToMany` -> Um para muitos. (Um médico tem várias consultas).
`@ManyToOne` -> Muitos para um. (Muitas consultas para um paciente).
`@ManyToMany` -> Muitos para Muitos. (Muitos pacientes para muitos médicos).

`Chave Primária (PK)` -> é o atributo(campo) que identifica a tabela(objeto) no BD.
`Chave Estrangeira (FK)` -> é o atributo PK que está mencionado em uma outra tabela, que por sua vez será uma chave estrangeira no BD.

OBS:
1. Sempre defina o lado "dono" da `relação(@JoinColumn)` o lado que tem a `FK(chave estrangeira).`"# sistema_escolar_java-main--Jose-Antonio-AV2" 
