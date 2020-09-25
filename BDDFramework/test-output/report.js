$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("functional.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "CRM Application Functional Test",
  "description": "",
  "id": "crm-application-functional-test",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 22,
      "value": "#Background: Given Login into CRM Application"
    }
  ],
  "line": 24,
  "name": "CRM Login and Logout test",
  "description": "",
  "id": "crm-application-functional-test;crm-login-and-logout-test",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@sample"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Login into CRM Application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Logout the Application",
  "keyword": "Then "
});
formatter.match({
  "location": "UIGlue.LoginApp()"
});
formatter.result({
  "duration": 15360074500,
  "status": "passed"
});
formatter.match({
  "location": "UIGlue.LogoutApp()"
});
formatter.result({
  "duration": 670248100,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "CRM Login , Navigate and Logout test",
  "description": "",
  "id": "crm-application-functional-test;crm-login-,-navigate-and-logout-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "Login into CRM Application",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Navigate the Menu",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Logout the Application",
  "keyword": "Then "
});
formatter.match({
  "location": "UIGlue.LoginApp()"
});
formatter.result({
  "duration": 14106344100,
  "status": "passed"
});
formatter.match({
  "location": "UIGlue.NavigateMenu()"
});
formatter.result({
  "duration": 25394197900,
  "status": "passed"
});
formatter.match({
  "location": "UIGlue.LogoutApp()"
});
formatter.result({
  "duration": 692299900,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "CRM Create New Contact",
  "description": "",
  "id": "crm-application-functional-test;crm-create-new-contact",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 34,
  "name": "Login into CRM Application",
  "keyword": "Given "
});
formatter.step({
  "line": 35,
  "name": "Navigate the Menu",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 36,
      "value": "#Then Find all the Broken links in the Home Page"
    }
  ],
  "line": 37,
  "name": "Create new Contacts based on below details",
  "rows": [
    {
      "cells": [
        "FieldName",
        "FieldValue"
      ],
      "line": 38
    },
    {
      "cells": [
        "FirstName",
        "Anil"
      ],
      "line": 39
    },
    {
      "cells": [
        "LastName",
        "Madishetty"
      ],
      "line": 40
    },
    {
      "cells": [
        "MiddleName",
        "Kumar"
      ],
      "line": 41
    },
    {
      "cells": [
        "Company",
        "SCB"
      ],
      "line": 42
    },
    {
      "cells": [
        "Email",
        "anils78@yahoo.com"
      ],
      "line": 43
    },
    {
      "cells": [
        "Category",
        "Lead"
      ],
      "line": 44
    },
    {
      "cells": [
        "Status",
        "Active"
      ],
      "line": 45
    },
    {
      "cells": [
        "Description",
        "Test Description"
      ],
      "line": 46
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "UIGlue.LoginApp()"
});
formatter.result({
  "duration": 13929256200,
  "status": "passed"
});
formatter.match({
  "location": "UIGlue.NavigateMenu()"
});
formatter.result({
  "duration": 25415050300,
  "status": "passed"
});
formatter.match({
  "location": "UIGlue.ContactScenarios(DataTable)"
});
formatter.result({
  "duration": 15505647400,
  "status": "passed"
});
});