# 🏥 Trabalho Prático – Sistema de Gerenciamento Hospitalar  

### 🎯 Objetivo  
Implementar um *Sistema de Gerenciamento Hospitalar* em *Java, aplicando conceitos avançados de **Programação Orientada a Objetos (POO), com foco em **herança, polimorfismo, encapsulamento, persistência de dados* e *regras de negócio mais complexas*.  

---
## Descrição do Projeto

Desenvolvimento de um sistema de gerenciamento hospitalar utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

## Dados do Aluno

- **Nome completo:** Daniel Valle Rodrigues Maia
- **Matrícula:** 251019780
- **Curso:** Engenharias
- **Turma:** FGA0158 - Turma 02

---

## Instruções para Compilação e Execução

1. **Compilação:**  
  Compilação : javac Hospital.java classes/*.java txt/*.java

2. **Execução:**  
    Execução: java Hospital.java

4. **Estrutura de Pastas:**  
  hospital → classes e hospital → txt
    
     
3. **Versão do JAVA utilizada:**  
  java version "24.0.2"

---

## Vídeo de Demonstração

(https://drive.google.com/drive/folders/1Kd-54Vj-tYiQ0guju_bZ2qLOIs8p4yX6)

---

## Prints da Execução

1. Menu Principal:  
   <img width="1188" height="121" alt="image" src="https://github.com/user-attachments/assets/478b1245-dfda-46a5-92e4-de199a40eb6a" />


2. Cadastro de Médico:  
   <img width="1304" height="239" alt="image" src="https://github.com/user-attachments/assets/33d0a9fa-2e07-498b-ad31-4a235036c8a1" />

   depois abre pra preencher a agenda, tem tudo explicado no vídeo dessa parte

   <img width="1272" height="254" alt="image" src="https://github.com/user-attachments/assets/bcfe0ee3-ea75-41b9-8246-cec837a9ddc2" />



3. Relatório de ?:  
   Pacientes Cadastrados:

<img width="1414" height="64" alt="image" src="https://github.com/user-attachments/assets/4efd1ee6-226c-45e7-9c52-945c2b1a2a99" />

   Médicos cadastrados:
   <img width="1413" height="639" alt="image" src="https://github.com/user-attachments/assets/713bad6a-5eb5-4f4c-a449-c610d1f73933" />

   Consultas futuras e passadas:
   <img width="1415" height="106" alt="image" src="https://github.com/user-attachments/assets/523bd11f-3f61-4da3-9972-1523914f1685" />

    Pacientes internados no momento:
    <img width="1411" height="143" alt="image" src="https://github.com/user-attachments/assets/e5ca5eb4-cb76-4e6d-b45b-320d24f290c4" />

    Estatísticas gerais:
    <img width="626" height="224" alt="image" src="https://github.com/user-attachments/assets/e1580a89-c4fc-46fd-ba90-0c30230e2514" />
    se você olhar todos esses arquivos txt aqui ficam todas as estatísticas que o hospital guarda, um exemplo de estatística geral que eu coloquei é se o paciente especial possuí alguma prioridade como gravidez ou obesidade, esta ficará registrada no "pacientes.txt"

   - Quantidade de pessoas em um determinado plano de saúde e quanto aquele plano *economizou* das pessoas que o usam:
   - <img width="1414" height="236" alt="image" src="https://github.com/user-attachments/assets/3804b364-895f-45e5-b629-e693a35bd6f4" />
     apenas guardei os nomes do plano, além de não fazer sentido guardar esse tipo de informação, devia estar escrito isso lá no topo porque este sendo o ultimo topico de todos e talvez sendo obrigatório tenho certeza que assim como eu muitas pessoas ao verem que tinha de ter essa função o hospital não tiveram tempo de realizá-la.


---

---

## Observações (Extras ou Dificuldades)
Ao final do projeto, eu sem querer apaguei alguma coisa da parte do meu código aqui do menu então talvez apresente alugns bugs nessa parte, não sei o que aconteceu, de verdade, e como so foi acontecer isso faltando menos de 1 hora pro envio então não da tempo de ajeitar. Se você quiser ajeito e te mando corrigido depois.
---

## Contato
danielvallemaia@gmail.com
---

### 🖥️ Descrição do Sistema  

O sistema deve simular o funcionamento de um hospital com cadastro de *pacientes, médicos, especialidades, consultas e internações*.  

1. *Cadastro de Pacientes*  ✔️
   - Pacientes comuns e pacientes especiais (ex: com plano de saúde).  
   - Cada paciente deve ter: nome, CPF, idade, histórico de consultas e internações.                                   

2. *Cadastro de Médicos*  ✔️
   - Médicos podem ter especialidades (ex: cardiologia, pediatria, ortopedia).  
   - Cada médico deve ter: nome, CRM, especialidade, custo da consulta e agenda de horários.  

3. *Agendamento de Consultas*  
   - Um paciente pode agendar uma consulta com um médico disponível.  
   - Consultas devem registrar: paciente, médico, data/hora, local, status (agendada, concluída, cancelada).  
   - Pacientes especiais (plano de saúde) podem ter *vantagens*, como desconto.  
   - Duas consultas não podem estar agendadas com o mesmo médico na mesma hora, ou no mesmo local e hora

4. *Consultas e Diagnósticos*  
   - Ao concluir uma consulta, o médico pode registrar *diagnóstico* e/ou *prescrição de medicamentos*.  
   - Cada consulta deve ser registrada no *histórico do paciente*.  

5. *Internações*  
   - Pacientes podem ser internados.  
   - Registrar: paciente, médico responsável, data de entrada, data de saída (se já liberado), quarto e custo da internação.  
   - Deve existir controle de *ocupação dos quartos* (não permitir duas internações no mesmo quarto simultaneamente).  
   - Internações devem poder ser canceladas, quando isso ocorrer, o sistema deve ser atualizado automaticamente.

6. *Planos de saúde*    
   -  Planos de saude podem ser cadastrados.
   -  Cada plano pode oferecer *descontos* para *especializações* diferentes, com possibilidade de descontos variados.
   -  Um paciente que tenha o plano de saúde deve ter o desconto aplicado.
   -  Deve existir a possibilidade de um plano *especial* que torna internação de menos de uma semana de duração gratuita.
   -  Pacientes com 60+ anos de idade devem ter descontos diferentes.

7. *Relatórios*  
   - Pacientes cadastrados (com histórico de consultas e internações).  
   - Médicos cadastrados (com agenda e número de consultas realizadas).  
   - Consultas futuras e passadas (com filtros por paciente, médico ou especialidade).  
   - Pacientes internados no momento (com tempo de internação).  
   - Estatísticas gerais (ex: médico que mais atendeu, especialidade mais procurada).  
   - Quantidade de pessoas em um determinado plano de saúde e quanto aquele plano *economizou* das pessoas que o usam.  


---

### ⚙️ Requisitos Técnicos  
- O sistema deve ser implementado em *Java*.  
- Interface via *terminal (linha de comando)*.  
- Os dados devem ser persistidos em *arquivos* (.txt ou .csv).  
- Deve existir *menu interativo*, permitindo navegar entre as opções principais.  

---

### 📊 Critérios de Avaliação  

1. *Modos da Aplicação (1,5)* → Cadastro de pacientes, médicos, planos de saúde, consultas e internações.  
2. *Armazenamento em arquivo (1,0)* → Dados persistidos corretamente, leitura e escrita funcional.  
3. *Herança (1,0)* → Ex.: Paciente e PacienteEspecial, Consulta e ConsultaEspecial, Médico e subclasses por especialidade.  
4. *Polimorfismo (1,0)* → Ex.: regras diferentes para agendamento, preços de consultas.
5. *Encapsulamento (1,0)* → Atributos privados, getters e setters adequados.  
6. *Modelagem (1,0)* → Estrutura de classes clara, bem planejada e com relacionamentos consistentes.  
7. *Execução (0,5)* → Sistema compila, roda sem erros e possui menus funcionais.  
8. *Qualidade do Código (1,0)* → Código limpo, organizado, nomes adequados e boas práticas.  
9. *Repositório (1,0)* → Uso adequado de versionamento, commits frequentes com mensagens claras.  
10. *README (1,0)* → Vídeo curto (máx. 5 min) demonstrando as funcionalidades + prints de execução + explicação da modelagem.  

🔹 *Total = 10 pontos*  
🔹 *Pontuação extra (até 1,5)* → Melhorias relevantes, como:  
- Sistema de triagem automática com fila de prioridade.  
- Estatísticas avançadas (tempo médio de internação, taxa de ocupação por especialidade).  
- Exportação de relatórios em formato .csv ou .pdf.  
- Implementação de testes unitários para classes principais.  
- Menu visual.
