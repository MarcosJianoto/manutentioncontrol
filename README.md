ManutentionControl
Descrição
O ManutentionControl é um software desenvolvido para o controle de manutenção de equipamentos e serviços. Focado em pequenos técnicos e empresas que realizam manutenções, o sistema permite o registro de instalações, controle de manutenções e envio de notificações. A aplicação foi construída com Java utilizando o framework Spring Boot e adota JWT para autenticação e autorização.

Este projeto oferece um backend com API RESTful documentada por Swagger, facilitando o entendimento e uso da API.

🚀 Tecnologias Utilizadas
- Java 21
- Spring Boot 3.4.4
- Spring Security (Autenticação via JWT)
- Spring Data JPA (Integração com banco de dados PostgreSQL)
- Swagger (Documentação da API)
- PostgreSQL (Banco de Dados)
- Maven (Gerenciamento de dependências)
- BCrypt (Criptografia de Senhas)

⚙️ Funcionalidades
- Cadastro e Login: Usuários podem se registrar e autenticar-se via JWT, com um fluxo simples de login.
- Controle de Usuários: Administradores têm permissões para cadastrar, editar e remover usuários.
- Histórico de Manutenções: Técnicos podem registrar e acessar informações sobre as manutenções realizadas.
- Segurança: A aplicação utiliza JWT para controlar o acesso aos endpoints, garantindo que apenas usuários com permissões adequadas possam acessar certas funcionalidades.

💻 Como Rodar o Projeto
Pré-requisitos

Antes de rodar o projeto localmente, é necessário ter instalado:

- Java 21: Certifique-se de que a versão do Java está configurada corretamente.
- PostgreSQL: O banco de dados utilizado é o PostgreSQL.
- Maven: Para gerenciar as dependências do projeto.
- Passos para Rodar Localmente
Clone o Repositório: Primeiro, baixe o repositório para seu computador. Isso pode ser feito através de uma interface gráfica do Git ou usando o comando de linha.
- Configure o Banco de Dados: No arquivo application.properties, ajuste as configurações de conexão com o seu banco de dados PostgreSQL. Aqui você precisa definir a URL do banco, o nome de usuário e a senha de acesso ao PostgreSQL.
-Compilação e Execução: Após a configuração, compile e execute o projeto. O Maven irá lidar com todas as dependências automaticamente.
- Acessando a API: Uma vez o servidor em execução, a API estará disponível em http://localhost:8080. Você pode interagir com os endpoints definidos, como o /users para obter informações sobre os usuários.
- Swagger UI: A documentação da API está acessível por meio do Swagger UI. Basta acessar http://localhost:8080/swagger-ui.html em seu navegador para ver os detalhes dos endpoints, seus parâmetros e exemplos de requisições.

📚 Como Usar a API
A API foi projetada para ser simples e intuitiva. Aqui estão algumas instruções sobre como interagir com ela:

- Cadastro de Usuário
Para cadastrar um novo usuário, envie uma requisição POST para o endpoint /auth/register. Você deve fornecer as informações necessárias, como e-mail, senha e papel (usuário ou administrador).

- Login de Usuário
Após o cadastro, um usuário pode realizar o login com uma requisição POST para o endpoint /auth/login. Isso retornará um token JWT, que deve ser incluído nos cabeçalhos das requisições subsequentes para autenticação.

- Controle de Usuários (Para Administradores)
Cadastrar Usuário: Administradores podem cadastrar novos usuários enviando uma requisição POST para /users.

- Editar Usuário: Para atualizar as informações de um usuário, use o método PUT para o mesmo endpoint /users.

- Deletar Usuário: Administradores também podem remover um usuário com o método DELETE para /users.

- Histórico de Manutenções
Técnicos podem registrar manutenções, e esse histórico pode ser visualizado posteriormente. Utilize os métodos POST, GET, PUT e DELETE no endpoint /history para interagir com as informações de manutenção.

📚 Swagger
A documentação da API está totalmente configurada no Swagger UI. Ao acessar o endereço http://localhost:8080/swagger-ui.html, você pode explorar todos os endpoints da aplicação, visualizar exemplos de requisições e entender melhor como os parâmetros devem ser passados.
O Swagger oferece uma interface gráfica intuitiva, permitindo que você faça chamadas à API diretamente pelo navegador, facilitando o teste e a compreensão do funcionamento dos endpoints.

🗂️ Estrutura de Diretórios
Aqui está um resumo da estrutura de diretórios do projeto:

src/main/java: Código-fonte do projeto, incluindo os controladores da API, serviços e configurações.

src/main/resources: Contém o arquivo application.properties e outros recursos necessários para a aplicação.

src/test: Testes da aplicação, utilizando o Spring Boot Test.

pom.xml: Arquivo de configuração do Maven, onde estão definidas as dependências do projeto.

💬 Contribuições
Embora este seja um projeto pessoal, contribuições são bem-vindas! Se você deseja ajudar a melhorar o projeto, pode abrir issues, sugerir melhorias ou enviar pull requests. Fique à vontade para propor novas funcionalidades, corrigir bugs ou melhorar a documentação.

📄 Licença
Este projeto está licenciado sob a MIT License, o que significa que você pode usar, modificar e distribuir o código, desde que mantenha a licença.

🔄 Como Personalizar
Se você quiser adicionar funcionalidades extras ou personalizar o projeto, pode seguir os seguintes passos:
Adicionar Novos Endpoints: Se você adicionar novos recursos ao projeto, pode documentar os novos endpoints na seção do Swagger.
Exemplos de Uso: Caso queira, pode adicionar exemplos mais específicos de uso ou detalhar a interação com certos endpoints que considera importantes.
Captura de Tela: Se houver uma interface visual ou mockups, você pode incluir imagens no repositório para ilustrar melhor o funcionamento do projeto.
Contato: Para dúvidas ou contribuições, você pode adicionar uma seção de contato no README.
