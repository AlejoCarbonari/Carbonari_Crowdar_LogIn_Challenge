# ====  TEST CASES ====

# language: es

Característica: LogIn HAPPY PATH

  Antecedentes:
    Dado que el usuario abre el navegador
    Y navega hacia Saucedemo
    Entonces debería visualizar la página de inicio

    Esquema del escenario: Usuario válido
      Cuando el usuario ingresa "<username>" en el campo username
      Y "<password>" en el campo password
      Y hace click en el botón submit
      Entonces debería visualizar el inventario de productos

      Ejemplos:
      | username                | password     |
      | standard_user           | secret_sauce |

    Esquema del escenario: Usuario bloqueado & credenciales erróneas
      Cuando el usuario ingresa "<username>" en el campo username
      Y "<password>" en el campo password
      Y hace click en el botón submit
      Entonces debería visualizar un error con el siguiente mensaje: "<expectedMessage>"

      Ejemplos:
      | username                | password     | expectedMessage                                                           |
      | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | error_username          | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      |                         | no_username  | Epic sadface: Username is required                                        |
      | no_password             |              | Epic sadface: Password is required                                        |


  Esquema del escenario: Usuario con problemas
      Cuando el usuario ingresa "<username>" en el campo username
      Y "<password>" en el campo password
      Y hace click en el botón submit
      Entonces debería visualizar correctamente las imágenes en el inventario

      Ejemplos:
      | username                | password     |
      | problem_user            | secret_sauce |

      # Éste último paso fallará!
