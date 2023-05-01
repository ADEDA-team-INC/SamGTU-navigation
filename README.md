# Навигация СамГТУ
> TODO

## Особенности
> TODO

## Технологический стек
- __Backend:__ Java, Spring Boot, Spring Data JPA, PostgreSQL и т.д.
- __Frontend:__ React, React Redux, i18next, FabricJs, Sass
- Docker, Docker Compose

## Установка и запуск
1. Убедитесь, что у вас установлен [Docker](https://www.docker.com/).
2. Склонируйте данный репозиторий:
```shell
git clone https://github.com/ADEDA-team-INC/SamGTU-navigation
```
3. Создайте `.env` файл внутри директории репозитория. Ниже указан пример
содержимого файла:
```text
SERVER_PORT = 8080
SPRING_DATASOURCE_URL = jdbc:postgresql://database:5432/samgtu-navigation

POSTGRES_DB = samgtu-navigation
POSTGRES_USERNAME = user
POSTGRES_PASSWORD = qwerty12

FRONTEND_PORT = 80
```
4. Запустите сервис:
```shell
docker compose up -d
```

Для запуска только бэкенда, используйте следующую команду:
```shell
docker compose up backend -d
```

5. Для остановки сервиса, введите следующее:
```shell
docker compose down
```

## Документация
Документация проекта с описанием API и архитектурой проекта доступна [здесь](DOCS.md).
