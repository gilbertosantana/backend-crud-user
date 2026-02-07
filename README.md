# 📦 Nome do Projeto

API backend desenvolvida para gerenciar **o cadastro de usuários**, permitindo **cadastrar, editar, deletar(soft delete), listar todos(filtro dinâmico e paginação) e listar por id os usuários**.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados: h2
- Maven

---

## 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado na sua máquina:

- Java 21+

---

## ⚙️ Configuração do Projeto

### 1️⃣ Clone o repositório
```bash
git clone https://github.com/gilbertosantana/backend-crud-user.git
cd backend-crud-user

mvn spring-boot:run
```
## 📌 Endpoints
| Método | Endpoint       | Descrição            |
| ------ | -------------- | -------------------- |
| POST   | /users         | Cadastro de usuário  |
| PUT    | /users         | Editar usuário       |
| GET    | /users         | Lista usuários       |
| GET    | /users/{id}    | Busca usuário por ID |
| DELETE | /users/{id}    | Deletar usuário      |


---

## 👨‍💻 Autor
Gilberto Santana

🔗 LinkedIn: https://linkedin.com/in/gilberto-santana-dev

📧 Email: gilbertosantoss307@email.com
