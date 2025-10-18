# GitHub Actions Deploy - Configuração

## 🚀 Workflow de Deploy Automático

Este projeto agora possui um workflow do GitHub Actions que automaticamente:
1. Compila a aplicação Spring Boot com Maven
2. Cria uma imagem Docker
3. Faz push da imagem para o Docker Hub
4. Faz deploy no VPS via SSH

## 📋 Pré-requisitos

### No VPS:
1. Docker e Docker Compose instalados
2. Porta 8080 liberada no firewall
3. Acesso SSH configurado

### No GitHub:
Configure os seguintes **Secrets** no repositório (Settings → Secrets and variables → Actions):

#### Docker Hub:
- `DOCKER_USERNAME` - Seu usuário do Docker Hub
- `DOCKER_PASSWORD` - Sua senha ou token do Docker Hub

#### VPS Access:
- `VPS_HOST` - IP ou domínio do seu VPS (ex: 192.168.1.100)
- `VPS_USERNAME` - Usuário SSH do VPS (ex: root ou ubuntu)
- `VPS_SSH_KEY` - Chave SSH privada para acesso ao VPS
- `VPS_PORT` - Porta SSH (geralmente 22)

#### Database:
- `DB_SERVER` - Host do banco MySQL (ex: mysql-db ou localhost)
- `DB_PORT` - Porta do MySQL (padrão: 3306)
- `DB_NAME` - Nome do banco de dados
- `DB_USERNAME` - Usuário do banco
- `DB_PASSWORD` - Senha do banco

#### SSL:
- `KEY_STORE_PASSWORD` - Senha do certificado SSL (cloudflare.p12)

## 🔑 Como gerar a chave SSH

No seu VPS, execute:
```bash
# Gerar par de chaves (se ainda não existir)
ssh-keygen -t rsa -b 4096 -C "github-actions"

# Adicionar chave pública ao authorized_keys
cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

# Copiar chave privada (cole isso no secret VPS_SSH_KEY)
cat ~/.ssh/id_rsa
```

## 🐳 Preparar o VPS

### 1. Instalar Docker:
```bash
# Ubuntu/Debian
curl -fsSL https://get.docker.com -o get-docker.sh
sudo sh get-docker.sh
sudo usermod -aG docker $USER

# Instalar Docker Compose
sudo apt-get update
sudo apt-get install docker-compose-plugin
```

### 2. Criar diretório para a aplicação (opcional):
```bash
mkdir -p ~/spring-rest-app
cd ~/spring-rest-app
```

## 📦 Deploy Manual (Alternativo)

Se preferir fazer deploy manual usando docker-compose:

### 1. No VPS, crie um arquivo `.env`:
```bash
# Database
DB_SERVER=mysql-db
DB_PORT=3306
DB_NAME=parking_spot_db
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
MYSQL_ROOT_PASSWORD=root_password

# Docker
DOCKER_USERNAME=seu_usuario_dockerhub

# SSL
KEY_STORE_PASSWORD=sua_senha_ssl
```

### 2. Copie o docker-compose.yml para o VPS:
```bash
scp docker-compose.yml usuario@seu-vps:~/spring-rest-app/
```

### 3. Execute no VPS:
```bash
cd ~/spring-rest-app
docker-compose up -d
```

## 🔄 Como funciona o Deploy Automático

1. **Trigger**: Ao fazer push na branch `main` ou manualmente via GitHub
2. **Build**: Compila o projeto com Maven
3. **Docker**: Cria e publica imagem no Docker Hub
4. **Deploy**: Conecta no VPS via SSH e atualiza o container

## 📝 Verificar Deploy no VPS

```bash
# Ver logs do container
docker logs -f spring-rest-app

# Ver status dos containers
docker ps

# Reiniciar container
docker restart spring-rest-app

# Parar container
docker stop spring-rest-app
```

## 🌐 Acessar a Aplicação

Após o deploy:
- **API**: https://seu-vps-ip:8080
- **Swagger**: https://seu-vps-ip:8080/swagger-ui.html
- **API Docs**: https://seu-vps-ip:8080/api-docs

## 🔧 Troubleshooting

### Container não inicia:
```bash
docker logs spring-rest-app
```

### Banco de dados não conecta:
- Verifique se o MySQL está rodando: `docker ps`
- Verifique as variáveis de ambiente: `docker inspect spring-rest-app`
- Verifique se DB_SERVER aponta para o nome correto do container

### Problemas de SSL:
- Certifique-se de que o arquivo `cloudflare.p12` está no classpath
- Verifique se KEY_STORE_PASSWORD está correto

## 🔐 Segurança

- Nunca commite senhas ou chaves no código
- Use sempre GitHub Secrets para informações sensíveis
- Mantenha a chave SSH privada segura
- Configure firewall no VPS para limitar acesso
- Use senhas fortes para banco de dados

## 🎯 Próximos Passos

1. Configure todos os Secrets no GitHub
2. Faça commit e push das alterações
3. Monitore o workflow na aba "Actions" do GitHub
4. Verifique os logs no VPS após o deploy

