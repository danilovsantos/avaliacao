
TECNOLOGIAS UTILIZADAS:

- Java 1.8
- JAX-RS/JERSEY
- HIBERNATE 4
- JPA 2
- MAVEN 3
- MYSQL 5


4) Quando voce digita a URL de um site (http://www.netshoes.com.br) no browser e pressiona enter, explique da forma que preferir, o que ocorre nesse processo do protocolo HTTP entre o Client e o Server. (5 pontos)

- O navegador monta o cabeçalho e corpo da requisição, informando a ação a ser executada.
- No caso de HTTPS, negocia com servidor o tipo de criptografia e certificado de segurança a serem utilizados.
- O servidor abre uma thread para receber a requisição e monta um objeto de sessão com ID padrão.
- O servidor pode recuperar informações adicionadas na sessão ou cookies para personalizar o comportamento do sistema de acordo com perfil do usuário.
- O servidor verifica se a url requisitada possui mapeamento, caso positivo executa a ação desejada, caso contrário encaminha para página de erro, montando cabeçalho e corpo do objeto http response.

