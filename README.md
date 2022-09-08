# Spring Boot Practice

> ### 👷 Work in progress
>
> Implement a simple REST API with Spring Boot.
> 
> Migrate from [dotnet6-vite](https://github.com/Chia1104/dotnet6-vite)

## Language and Tools

<div align="center">
  <img src="https://skillicons.dev/icons?i=ts,kotlin,vite,react,spring,postgres,docker" />
</div>

## Get Started

Generate the `.env` file from `.env.example` and fill in the values.

```bash
# Server
$ cp .env.example .env
```

Install dependencies

```bash
# Client
$ cd client
$ pnpm install
```

Start the project

```bash
# Client
$ cd client
$ pnpm dev

# Server
$ cd server
$ gradle bootRun
```

Docker Compose

```bash
$ docker-compose up -d
```