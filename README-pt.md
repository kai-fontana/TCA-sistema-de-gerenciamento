# Projeto Prisma 2.0: Sistema de Gerenciamento de Educandos

## 📄 Introdução

* **Breve Descrição do Projeto:** O Prisma 2.0 é um **Trabalho de Conclusão de Aprendizagem (TCA)** que consiste no desenvolvimento de um sistema de registro e gerenciamento de educandos, concebido para substituir o sistema antigo (_Prisma_) do Polo de Aprendizagem do **Centro Social Marista (CESMAR)**, que será descontinuado.
* **Objetivo:** O principal objetivo do projeto é fornecer uma plataforma concisa, bem estruturada e executável para a área administrativa do CESMAR, otimizando o processo de registro, acompanhamento de frequência e gerenciamento de turmas e educandos.
* **Problemática:** A necessidade surgiu da iminente descontinuação do sistema legado (*Prisma*), exigindo o desenvolvimento de uma nova solução robusta e moderna para garantir a continuidade e eficiência na gestão dos dados dos educandos do Polo de Aprendizagem.
* **Público-Alvo:** Colaboradores da área administrativa do Centro Social Marista (CESMAR), incluindo gestores, coordenadores e responsáveis pelo registro e acompanhamento dos educandos.

---

## 💻 Tecnologias Utilizadas

O projeto foi inicializado a partir do Spring Initializr e segue o padrão de arquitetura **MVC (Model-View-Controller)** para organizar o código em diferentes camadas e separar o Front-End do Back-End.

| Categoria | Tecnologia/Padrão | Detalhes |
| :---: | :---: | :---: |
| Front-End | **Thymeleaf** | Thymeleaf liga o HTML diretamente ao Back-End. |
| Biblioteca | **Bootstrap** | Utilizado para adicionar templates e design responsivo. |
| Back-End | **Java** | Linguagem principal da aplicação. |
| Framework | **Spring Boot** | Versão 3.5.7. |
| Gerenciador | **Maven** | Gerenciador de dependências. |
| Arquitetura | **MVC (Model-View-Controller)** | Separação lógica entre Back-End e Front-End. |
| Banco de Dados | **PostgreSQL** | Vinculado à aplicação via Postgre Driver. |
| IDE | **VS Code, IntelliJ** | Utilizada para o desenvolvimento. |

### Dependências Principais
O projeto utiliza as seguintes dependências:
* `Spring Web`
* `DevTools`
* `ThymeLeaf`
* `Lombok`
* `PostgreSQL (Postgre Driver)`

---

## ⚙️ Processo de Desenvolvimento

O desenvolvimento do Prisma 2.0 seguiu um ciclo bem definido, passando pelas seguintes etapas:

### 1. Planejamento
Nesta fase, foi realizada a análise das funcionalidades do sistema legado e o levantamento de todos os **requisitos** junto ao CESMAR. Definimos a **arquitetura MVC** e escolhemos as tecnologias (Java, Spring Boot, PostgreSQL) com base na robustez e escalabilidade. O escopo do projeto foi detalhado, resultando nas 4 páginas principais e suas funcionalidades.

### 2. Prototipagem
Fizemos um pro
![Texto Alternativo](print-prototipo.png)
<img src="print-prototipo.png" alt="Texto Alternativo">

### 3. Codificação
* **Back-End:** Implementação da lógica de negócios, das APIs REST, dos *Controllers* (responsáveis pela comunicação) e dos *Models* (entidades e regras de dados) utilizando **Java** e **Spring Boot**.
* **Front-End:** Desenvolvimento das interfaces de usuário (*Views*) utilizando **HTML** e **Thymeleaf** para integração dinâmica com o Back-End, e **Bootstrap** para o *layout* e *design* responsivo.
* **Banco de Dados:** Criação do esquema de banco de dados no **PostgreSQL** e configuração da conexão via *Postgre Driver*.

### 4. Testes
Realizamos testes unitários e de integração para garantir que cada funcionalidade (ex: Login, Cadastro de Turmas, Chamada) estivesse operando conforme o esperado. O foco foi na **integridade dos dados** e na **segurança da autenticação**. Foram realizados testes funcionais com o cliente final para validar a usabilidade e aderência aos requisitos.

### 5. Deploy


---

## ⚠️ Dificuldades e Soluções

O desenvolvimento de qualquer sistema apresenta desafios. Os principais obstáculos e as soluções implementadas foram:

* **Dificuldade:** **Integração do Thymeleaf com o Spring Security (Autenticação):** Garantir que a segurança (login e controle de acesso) funcionasse de forma fluida com a *view engine*.
    * **Solução:** Estudo e aplicação detalhada das *tags* de segurança do Thymeleaf e configuração granular do Spring Security, garantindo que apenas usuários autenticados pudessem acessar as rotas internas.
* **Dificuldade:** **Mapeamento Objeto-Relacional (ORM) Complexo:** Lidar com as relações entre as entidades (Educandos, Turmas, Chamada, Frequência) no PostgreSQL via JPA/Hibernate.
    * **Solução:** Definição clara das chaves primárias e estrangeiras e o uso correto das anotações `@OneToMany`, `@ManyToOne` e `@ManyToMany` no Java, assegurando a integridade dos dados e o desempenho das consultas.


---

## 📈 Resultado Final e Aprendizados

### Resultado Final
Por fim, após todas as etapas de desenvolvimento deste projeto, segue abaixo a estrutura final:

### 1. Login
* Autenticação via e-mail e senha.
* Opção de realização de novo cadastro.
* Opção de recuperação ou troca de senha.

### 2. Página Inicial
* Exibição do nome do administrador.
* Lista das turmas do Polo.
* Recursos de barra de pesquisa, ícone de notificações e mensagens.
* Menu suspenso (drop-down) com opções para editar perfil, trocar e sair da conta.
* Cadastro de educandos.
* Lista de chamada de turmas.

### 3. Cadastro de Turmas
* Cadastro de turmas (adição, remoção e edição).
* Visualiazação de informações das turmas.

### 4. Turmas (Visualização Detalhada)
* Lista de educandos com nome completo, email e foto.
* Exibição da frequência média da turma.

### 5. Chamada
* Controle de frequência com menções para **Presente (P)**, **Falta (F)** e **Falta Justificada (FJ)**.
* Opções de adição, edição e exclusão de educandos na lista
* Acompanhamento do calendário e eventos do Polo..

### Aprendizados
O desenvolvimento do projeto proporcionou valiosos aprendizados em diversas áreas:
* **Arquitetura de Software:** Entendimento prático do padrão **MVC** e sua aplicação no Spring Boot, separando as preocupações do Front-End e Back-End.
* **Desenvolvimento Full Stack:** Experiência completa na interconexão entre **Java** (lógica de negócios) e **Thymeleaf/Bootstrap** (interface de usuário).
* **Gerenciamento de Banco de Dados:** Consolidação de conhecimentos em **PostgreSQL** e mapeamento **JPA/Hibernate**, crucial para a persistência e integridade dos dados.
* **Trabalho em Equipe:** Aprimoramento das habilidades de colaboração, divisão de tarefas e resolução conjunta de problemas em um projeto de grande porte.

---

## 🤝 Conclusão

O desenvolvimento do **Prisma 2.0** foi, sem dúvida, o nosso maior projeto. Encaramos um desafio técnico complexo, mas o verdadeiro diferencial para o sucesso foi a nossa capacidade de trabalhar juntos. Graças à união da equipe, à boa comunicação e a uma divisão de tarefas equilibrada, conseguimos superar os imprevistos e conduzir o projeto com maestria.
Essa jornada nos trouxe uma experiência profissional valiosa e aprendizados que vão muito além do código. Entregamos uma solução bem estruturada e redondinha, com a satisfação de termos crescido profissionalmente e provado a força da nossa colaboração.
---

## 💡 Possíveis Melhorias Futuras

Para versões futuras, sugerimos as seguintes expansões e otimizações:
* **Módulo de Relatórios Avançados:** Implementar a geração de relatórios personalizados (PDF/Excel) sobre frequência, desempenho por turma e indicadores anuais.
* **Notificações Automáticas:** Adicionar um sistema de envio de e-mails ou notificações via SMS para responsáveis em casos de falta injustificada.
* **Integração com Sistemas Externos:** Preparar a arquitetura para futura integração com outros sistemas de gestão do CESMAR, como módulos financeiros ou pedagógicos.

---

## 👥 Participantes (Equipe TCA)

O projeto foi desenvolvido em equipe por:
* Gabriel Tavares
* Kaillanny Fontana dos Santos
* Luis Castro
* Marcos Yuri Rosa de Oliveira