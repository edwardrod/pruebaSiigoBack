Feature: Verificación de servicios en ReqRes

  @ValidacionApisReqres
  Scenario: Crear un nuevo usuario
    When el usuario envía una solicitud POST
      | name  | job    |
      | Eduar | Tester |
    Then la respuesta debería tener el código 201
    And los datos del usuario deberían coincidir con los enviados

  @ValidacionApisReqres
  Scenario Outline: Consultar información de un usuario
    When el usuario envía una solicitud GET pagina <id>
    Then la respuesta debería tener el código 200
    And la respuesta debería contener los datos del usuario
    Examples:
      | id |
      | 1  |
      | 2  |

  @ValidacionApisReqres
  Scenario: Actualizar un usuario
    When el usuario envía una solicitud PUT
      | name   | job     |
      | Maria  | Manager |
    Then la respuesta debería tener el código 200
    And los datos del usuario deberían coincidir con los enviados

  @ValidacionApisReqres
  Scenario: Eliminar un usuario
    When el usuario envía una solicitud DELETE con ID 2
    Then la respuesta debería tener el código 204
