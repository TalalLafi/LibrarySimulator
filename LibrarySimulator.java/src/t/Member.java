package t;
public class Member {
//a
// Group Members: Talal, Faisal, Abdullah
// GitHub Repository Link: https://github.com/TalalLafi/LibrarySimulator
    private int id;
    private String name;
    private int borrowedCount;
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // متغيرات عامة للمكتبة (Static Variables)
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    
    // --- 2. المُنشئ (Constructor) ---
    
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
        
        // تهيئة (Reset) باقي الإحصائيات
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
    }

    
    // --- 3. الوظائف (Methods) ---

    private boolean canBorrow() {
        return this.borrowedCount < 5;
    }

    private boolean canReturn() {
        return this.borrowedCount > 0;
    }

    public void viewBorrowedCount() {
        System.out.println("عدد الكتب المستعارة حالياً: " + this.borrowedCount);
        
        // تحديث العدادات
        this.numViewBorrowed++;
        TotalViewBorrowed++;
    }

    public boolean borrowOne() {
        if (canBorrow()) {
            this.borrowedCount++;
            
            double fee = 0.50;
            this.sessionFees += fee;
            TotalRevenue += fee; 
            
            this.numBorrows++;
            TotalBorrows++;
            
            System.out.println("تمت استعارة الكتاب بنجاح.");
            return true;
        } else {
            System.out.println("لا يمكنك استعارة المزيد من الكتب (الحد الأقصى 5).");
            return false;
        }
    }

    public boolean returnOne() {
        if (canReturn()) {
            this.borrowedCount--;
            
            this.numReturns++;
            TotalReturns++;
            
            System.out.println("تم إرجاع الكتاب بنجاح.");
            return true;
        } else {
            System.out.println("ليس لديك كتب لإرجاعها.");
            return false;
        }
    }

    public void displayStatistics() {
        System.out.println("--- إحصائيات العضو: " + this.name + " ---");
        System.out.println("عدد مرات الاستعارة: " + this.numBorrows);
        System.out.println("عدد مرات الإرجاع: " + this.numReturns);
        System.out.println("عدد مرات عرض الكتب المستعارة: " + this.numViewBorrowed);
        System.out.println("إجمالي الرسوم المدفوعة: " + this.sessionFees);
        System.out.println("------------------------------------");
    }

    public void reset() {
        this.numViewBorrowed = 0;
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0.0;
        System.out.println("تمت إعادة ضبط إحصائيات العضو " + this.name);
    }

    
    // --- 4. Setters & Getters (as needed) ---
    
    // مطلوب لطباعة الاسم في قائمة الترحيب
    public String getName() {
        return this.name;
    }

    // مطلوب لطباعة ID في لوحة التحكم
    public int getId() {
        return this.id;
    }
    
    // (*** هذه هي الدالة الجديدة المطلوبة ***)
    // مطلوبة لطباعة "Currently Borrowed" في لوحة التحكم
    public int getBorrowedCount() {
        return this.borrowedCount;
    }
}
