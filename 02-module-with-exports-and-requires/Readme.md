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
        ModuleOne.callMe();
    }
}
```

## Run the code (Error for now)
If we run the code using `./run.sh com.moduletwo ModuleTwo` we will get error

```
src/com.moduletwo/com/moduletwo/ModuleTwo.java:3: error: package com.moduleone is not visible
import com.moduleone.ModuleOne;
          ^
  (package com.moduleone is declared in module com.moduleone, but module com.moduletwo does not read it)
1 error
```
We get this error because we have not specified that out `com.moduletwo` depends on `com.moduleone`. To do this we will use `requires` keyword

## Declare dependencies / requires package;
So we tell `com.moduletwo` require `com.moduleone` using `requires` statement. Simply add `requires com.moduletwo;` on `module-info.java` of `com.moduletwo`.

## Compile and run (ERROR AGAIN)
But this time you will get another error
```
src/com.moduletwo/com/moduletwo/ModuleTwo.java:3: error: package com.moduleone is not visible
import com.moduleone.ModuleOne;
          ^
  (package com.moduleone is declared in module com.moduleone, which does not export it)
1 error
```
If you look closely it says, `com.moduleone` does not exports it. So let's do that.

## Make code visible outside module / exports parts of code to other module
We need to add `exports` statement on module declartion file.
On `com.moduleone` `module-info.java` add `exports com.moduleone;`

## Run again
Now you will get console output.

## Conclusion
Hope this simple application helped you understand how `exports` and `requires` keyword works.
