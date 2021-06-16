#language: pt
Funcionalidade: Consulta de livros na API Nyt Books

@ConsultaLivroLista
Cenário: Consultar listagem de livros na API Nyt Books
	Dado que seja consultada a API Nyt Books
	Quando for efetivada a consulta de livros do tipo '<tipo>'
	Então a API deverá conter o livro '<livro>' na lista apresentada
	
	Exemplos:
	| tipo              | livro                |
	| hardcover-fiction | THE MIDNIGHT LIBRARY |
	
@ConsultaLivroData
Cenário: Consultar listagem de livros por data na API Nyt Books
	Dado que seja consultada a API Nyt Books
	Quando for efetivada a consulta de livros com data '<data>'
	Então a API deverá conter o livro '<livro>' na lista apresentada
	
	Exemplos:
	| data       | livro          |
	| 2019-01-20 | FIRE AND BLOOD |