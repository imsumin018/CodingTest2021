class Banking {
    public boolean solution(String account1, String account2, int count) {
        java.util.List<Thread> threads = new java.util.ArrayList<>();
        for (int i=0; i<count; i++) {
            final int condition = i % 2;
            Thread thread = new Thread(() -> {
                if (condition == 0) {
                    transfer(account1, account2, 1);
                } else {
                    transfer(account2, account1, 1);
                }
            });
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return true;
    }
    public void transfer(String fromAccount, String toAccount, int money) {
//4
 
        if (fromAccount.equalsIgnoreCase(toAccount)) {
            return;
        }
        if ( money<=0) { 
            return;
        }
        
/*

public void transfer(Account acc1, Account acc2, BigDecimal value) {
    Object lock1 = acc1.ID < acc2.ID ? acc1.LOCK : acc2.LOCK;
    Object lock2 = acc1.ID < acc2.ID ? acc2.LOCK : acc1.LOCK;
    synchronized (lock1) {
       synchronized (lock2) {
          acc1.widrawal(value);
          acc2.send(value);
       }
    }
}


*/ 
        /*
        boolean fromLock = false;
        boolean toLock = false;

        try {
            while (!fromLock || !toLock) {
                fromLock = fromAccount.getLock().tryLock(
                        (long) (Math.random() * 1000), TimeUnit.MILLISECONDS);
                toLock = to.getLock().tryLock((long) (Math.random() * 1000),
                        TimeUnit.MILLISECONDS);
            }
            from.withdraw(amount);
            to.deposit(amount);
        } catch (InterruptedException e) {
            System.out.println("Transfer from account #" + from.getId()
             + " to account #" + to.getId() + " was interrupted");
        } finally {
            from.getLock().unlock();
            to.getLock().unlock();
        }
*/  
        int comparable = fromAccount.compareToIgnoreCase(toAccount);
        
        String account1 = fromAccount;
        String account2 = toAccount;
   //4
        synchronized(comparable < 0 ? account1: account2) {
            synchronized(comparable < 0? account2: account1) {
                String message = String.format("Transfer %d from %s to %s", money, account1, account2);
                System.out.println(message);
            }
        }
    }
}

//http://web.mit.edu/6.031/www/sp18/classes/21-locks/
/**
 * public void friend(Wizard that) {
        Wizard first, second;
        if (this.name.compareTo(that.name) < 0) {
            first = this; second = that;
        } else {
            first = that; second = this;
        }
        synchronized (first) {
            synchronized (second) {
                if (friends.add(that)) {
                    that.friend(this);
                } 
            }
        }
    }

    
 */
//https://github.com/Ivan31r/Skillbox/blob/8dcd15baac4370a93ee7db791915c30699287384/11_Multithreading/src/main/java/Transactions/Bank.java
//https://github.com/s19200/BYT-unit_testing/blob/3890cbbfedf0339fec2ddf48df3c5f0e1ca36625/Lab1/src/b_Money/Bank.java
//https://github.com/sfill70/java_basics/blob/25535de99a5d1f0eb12937a7120a5656886f32d9/11_Multithreading/Transactions/src/main/java/Bank.java
//https://github.com/yufeicheng/springboot/blob/73a2dae7ff4362912479e5ca4470a71e15267d55/gradle_java/interview/src/main/java/cyf/gradle/interview/service/time_concurrent/deadlock/AvoidDeadlockService.java
//https://github.com/Timzmei/java_basics/blob/d3072cf629b821723c9d9fb133e56bfaa7759064/11_Multithreading/Transactions/src/main/java/Bank.java
//https://github.com/WRGr00t/SkillboxJava/blob/4b29116aec99be79315c5be48db3d9457787ab0a/Unit11/Transactions/src/Bank.java



/**
 *  String fromAccountId = from.id.toString().intern();
    String toAccountId = to.id.toString().intern();
    String lock1, lock2;

    if (from.id < to.id) {
       lock1 = fromAccountId;
       lock2 = toAccountId;
    } else {
       lock1 = toAccountId;
       lock2 = fromAccountId;
    }

    // synchronizing from this point, since balances are checked
    synchronized(lock1) {
        synchronized(lock2) {
            BigDecimal fromValue = from.getAmount();
            if (amount.compareTo(fromValue) < 0)
                 return false;

            BigDecimal toValue = to.getAmount();
            from.setAmount(fromValue.add(amount.negate()));
            to.setAmount(toValue.add(amount));
            return true;
        }
    }
}

*/
