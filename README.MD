#----------------------------DELETE

curl -X DELETE \
  http://localhost:8080/order/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: fa9776ac-87ae-517f-beae-10dbfeb1886a'

#-------------------------POST

curl -X POST \
  http://localhost:8080/order/ \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 3748e076-8302-075a-20e9-e526032a50ed' \
  -d '{
    "idOrder": 1002,
    "email": "dsadasdasdasdasdasdas@email.com.br",
    "nome": "Nome",
    "endereco": "Endereço",
    "valorTotal": 40,
    "formaPagamento": "BOLETO",
    "dataPedido": "05/31/2019",
    "status": "AGUARDANDO PAGAMENTO",
    "idTransacao": "1256-521452-32515471-682476",
    "numeroCartao": "02541 02142 01795 03458 69985",
    "validadeCartao": "02/24",
    "bandeiraCartao": "VISA",
    "itens": [
        {
            "idItem": 0,
            "idOrder": 1,
            "descricao": "Produto 0",
            "quantidade": 2,
            "valorUnitario": 10
        },
        {
            "idItem": 1,
            "idOrder": 1,
            "descricao": "Produto 1",
            "quantidade": 3,
            "valorUnitario": 10
        },
        {
            "idItem": 2,
            "idOrder": 1,
            "descricao": "Produto 2",
            "quantidade": 4,
            "valorUnitario": 10
        },
        {
            "idItem": 3,
            "idOrder": 1,
            "descricao": "Produto 3",
            "quantidade": 5,
            "valorUnitario": 10
        }
    ]
}'


#------------------------GET

curl -X GET \
  http://localhost:8080/order/findByid/23 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 4745cd38-9546-1cc0-8369-a763c7e675b3'
  
  
#--------------------PUT

curl -X PUT \
  http://localhost:8080/order/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: c5a00293-1e7f-1613-0c67-dfb172a02878' \
  -d '{
    "idOrder": 1,
    "email": "emailxxxxxxxx@email.com.br",
    "nome": "Nome",
    "endereco": "Endereço",
    "valorTotal": 40,
    "formaPagamento": "BOLETO",
    "dataPedido": "05/31/2019",
    "status": "AGUARDANDO PAGAMENTO",
    "idTransacao": "1256-521452-32515471-682476",
    "numeroCartao": "02541 02142 01795 03458 69985",
    "validadeCartao": "02/24",
    "bandeiraCartao": "VISA",
    "itens": [
        {
            "idItem": 0,
            "idOrder": 1,
            "descricao": "Produto 0",
            "quantidade": 2,
            "valorUnitario": 10
        },
        {
            "idItem": 1,
            "idOrder": 1,
            "descricao": "Produto 1",
            "quantidade": 3,
            "valorUnitario": 10
        },
        {
            "idItem": 2,
            "idOrder": 1,
            "descricao": "Produto 2",
            "quantidade": 4,
            "valorUnitario": 10
        },
        {
            "idItem": 3,
            "idOrder": 1,
            "descricao": "Produto 3",
            "quantidade": 5,
            "valorUnitario": 10
        }
    ]
}'
