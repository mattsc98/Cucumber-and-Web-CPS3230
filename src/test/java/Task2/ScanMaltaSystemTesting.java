package Task2;

 class ScanMaltaSystemTesting {
    private boolean loggedIn = false, loggedOut = true, searching = false,
            addingToCart = false, removingFromCart = false, checkingOut = false;

    boolean isLoggedIn() {
        return loggedIn;
    }

    boolean isLoggedOut() {
        return loggedOut;
    }

    boolean isSearching() {
        return searching;
    }

    boolean isAddingToCart() {
        return addingToCart;
    }

    boolean isRemovingFromCart() {
        return removingFromCart;
    }

    boolean isCheckingOut() {
        return checkingOut;
    }

    void loggingIn() {
        if (loggedIn && !loggedOut && !searching && !addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = true;
        }
    }

    void loggingOut() {
        if (!loggedIn && loggedOut && !searching && !addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
        }
    }

    void searchItem() {
        if (!loggedIn && !loggedOut && searching && !addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            searching = true;
        }
    }

    void addToCart() {
        if (!loggedIn && !loggedOut && !searching && addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            addingToCart = true;
        }
    }

    void removeFromCart() {
        if (!loggedIn && !loggedOut && !searching && !addingToCart && removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            removingFromCart = true;
        }
    }

    void checkout() {
        if (!loggedIn && !loggedOut && !searching && !addingToCart && !removingFromCart && checkingOut) {
            loggedOut = false;
            loggedIn = true;
            checkingOut = true;
        }
    }


}
