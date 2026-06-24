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
