# Arquitetura

O Nexus ERP será organizado utilizando Package by Feature.

Cada módulo possuirá sua própria estrutura contendo:

- Controller
- Service
- Repository
- Entity
- DTO
- Mapper
- Validation
- Exception

Toda comunicação será realizada através de uma API REST.

O banco de dados será PostgreSQL.

As autenticações serão realizadas utilizando JWT.

Todas as alterações importantes serão registradas através de auditoria.