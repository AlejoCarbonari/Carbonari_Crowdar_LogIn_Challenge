# Carbonari_Crowdar_LogIn_Challenge

FEATURES: LogIn HAPPY PATH

Background:
> ✅ Dado que el usuario abre el navegador <br />
✅ Y navega hacia Saucedemo <br />
✅ Entonces debería visualizar la página de inicio <br />

First Scenario: Usuario válido
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar el inventario de productos <br />

      Ejemplos:
         | username                | password     |
         | standard_user           | secret_sauce |

Second Scenario: Usuario bloqueado & credenciales erróneas
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar un error con el siguiente mensaje: "<expectedMessage>" <br />

      Ejemplos:
            | username                | password     | expectedMessage                                                           |
            | locked_out_user         | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
            | error_username          | secret_sauce | Epic sadface: Username and password do not match any user in this service |
            |                         | no_username  | Epic sadface: Username is required                                        |
            | no_password             |              | Epic sadface: Password is required                                        |
      
Esquema del escenario: Usuario con problemas
> ✅ Cuando el usuario ingresa "<username>" en el campo username <br />
✅ Y "<password>" en el campo password <br />
✅ Y hace click en el botón submit <br />
✅ Entonces debería visualizar correctamente las imágenes en el inventario <br />

      Ejemplos:
            | username                | password     |
            | problem_user            | secret_sauce |

   # Éste último paso fallará!
