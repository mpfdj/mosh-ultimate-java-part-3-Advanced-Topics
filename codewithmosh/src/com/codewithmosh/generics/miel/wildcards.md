You can use generic wildcards in several specific places in Java code. Here are the *main locations* with simple examples:

---

## 📍 *1. Method Parameters (Most Common)*

java
import java.util.List;

public class WildcardLocations {
    
    // ✅ Unbounded wildcard in parameter
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }
    
    // ✅ Upper bounded wildcard in parameter
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }
    
    // ✅ Lower bounded wildcard in parameter  
    public static void addIntegers(List<? super Integer> list) {
        list.add(42);
    }
}


---

## 📍 *2. Local Variable Declarations*

java
import java.util.List;
import java.util.ArrayList;

public class LocalVariableWildcards {
    public static void main(String[] args) {
        
        // ✅ Unbounded wildcard in local variable
        List<?> unknownList = new ArrayList<String>();
        unknownList = new ArrayList<Integer>(); // Can reassign to any type
        
        // ✅ Upper bounded wildcard in local variable
        List<? extends Number> numbers = new ArrayList<Integer>();
        numbers = new ArrayList<Double>(); // Can reassign to any Number subtype
        
        // ✅ Lower bounded wildcard in local variable
        List<? super Integer> integers = new ArrayList<Number>();
        integers = new ArrayList<Object>(); // Can reassign to any Integer supertype
        
        // Reading from wildcard variables
        Object obj = unknownList.get(0);
        Number num = numbers.get(0);
        
        // Writing to lower bound variable
        integers.add(100); // ✓ OK - can add Integer
    }
}


---

## 📍 *3. Return Types*

java
import java.util.List;
import java.util.Collections;

public class ReturnTypeWildcards {
    
    // ✅ Method returning unbounded wildcard type
    public static List<?> getEmptyList() {
        return Collections.emptyList();
    }
    
    // ✅ Method returning upper bounded wildcard type
    public static List<? extends Number> getNumberList() {
        return new ArrayList<Integer>();
    }
}


---

## 📍 *4. Field Declarations*

java
import java.util.List;
import java.util.ArrayList;

public class ClassWithWildcardFields {
    
    // ✅ Field with unbounded wildcard
    private List<?> unknownItems;
    
    // ✅ Field with upper bounded wildcard
    private List<? extends Comparable> comparableItems;
    
    // ✅ Field with lower bounded wildcard  
    private List<? super String> stringSuperItems;
    
    public void initializeFields() {
        unknownItems = new ArrayList<Integer>();
        comparableItems = new ArrayList<String>();
        stringSuperItems = new ArrayList<Object>();
    }
}


---

## 📍 *5. Cast Expressions*

java
import java.util.List;
import java.util.ArrayList;

public class CastWithWildcards {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        rawList.add("test");
        
        // ✅ Wildcard in cast
        List<?> wildcardList = (List<?>) rawList;
        
        // ✅ Upper bound in cast
        List<? extends Number> numberList = (List<? extends Number>) rawList;
    }
}


---

## 📍 *6. instanceof Checks*

java
import java.util.List;
import java.util.ArrayList;

public class InstanceofWildcards {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        
        // ✅ Wildcard in instanceof
        if (stringList instanceof List<?>) {
            System.out.println("It's a List of some type");
        }
        
        // This works but generates warning - usually avoided
        if (stringList instanceof List) {
            System.out.println("It's a raw List");
        }
    }
}


---

## ❌ *Where You CANNOT Use Wildcards:*

java
public class InvalidWildcardUses {
    
    // ❌ CANNOT use in class definition
    // class MyClass<?> {}  // Compile error!
    
    // ❌ CANNOT use as type parameter in generic method definition
    // public <?> void method() {}  // Compile error!
    
    // ❌ CANNOT use in new instance creation
    public void invalidUses() {
        // List<?> list = new ArrayList<?>();  // Compile error!
        // List<? extends Number> nums = new ArrayList<? extends Number>(); // Error!
    }
    
    // ❌ CANNOT use in extends/implements for class
    // class MyList implements List<?> {}  // Compile error!
}


---

## 💡 *Valid vs Invalid Examples:*

### *✅ VALID:*
java
// Method parameter
void process(List<?> list)

// Local variable  
List<? extends Number> numbers = new ArrayList<Integer>();

// Return type
List<? super String> getList()

// Field
private List<?> items;

// Cast
(List<?>) someObject

// instanceof
obj instanceof List<?>


### *❌ INVALID:*
java
// Class definition
class MyClass<?> {}

// Generic method type parameter
<T?> void method()

// Object creation
new ArrayList<?>()

// extends/implements
class MyList implements List<?> {}

// Array creation
new List<?>[10]


---

## 🎯 *Most Common Use Case Summary:*

java
import java.util.List;

public class MostCommonUses {
    
    // ✅ #1 Most Common: Method Parameters
    public static void processAnyList(List<?> list) {
        // Can read as Object
        for (Object item : list) {
            System.out.println(item);
        }
    }
    
    // ✅ #2 Common: Producer method parameters (PECS)
    public static double sum(List<? extends Number> numbers) {
        double total = 0;
        for (Number n : numbers) {
            total += n.doubleValue();
        }
        return total;
    }
    
    // ✅ #3 Common: Consumer method parameters (PECS)  
    public static void fillList(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}


*In practice, you'll use wildcards primarily in method parameters* to create flexible, type-safe APIs! 🚀