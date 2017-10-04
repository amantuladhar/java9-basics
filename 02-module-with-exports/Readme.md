# Java Module Using exports

## Create modules
For this example we will create two modules: `com.moduleone` and `com.moduletwo`

## Scenario
`com.moduleone` will have some code that will be used my `com.moduletwo`

## `com.moduleone` code
For now just create a simple method that will print some message

```
package com.moduleone;

public class ModuleOne {
    public static void callMe(){
        System.out.println("Hello from module one");
    }
}
```

## `com.moduletwo` code
Create a class that will uses code from `com.moduleone`
```
package com.moduletwo;

import com.moduleone.ModuleOne;

public class ModuleTwo {
    public static void main(String[] args){
        ModuleOne.callme();
    }
}
```