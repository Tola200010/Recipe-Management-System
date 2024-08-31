/**
 Get number of fields class declares (the ones inherited should be excluded).
 */
class FieldGetter {

    public int getNumberOfFieldsClassDeclares(Class<?> clazz) {
        // Add implementation here
        A a = new B();
        int count = 0;
        count += clazz.getDeclaredFields().length;
        return count;
    }

}

class A{

}
class B extends A{

}