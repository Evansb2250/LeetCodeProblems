package patterns.comander

import java.util.*

internal interface Command {
    fun execute()
    fun unexecute()
}

object Cart {
    private val cartItems = mutableListOf<String>()

    fun addToCart(item: String) {
        cartItems.add(item)
    }

    fun removeFromCart(item: String) {
        cartItems.remove(item)
    }

    fun getCart() = cartItems
}


internal class AddToCartCommand(
    val cart: Cart = Cart,
    val item: String
) : Command {
    override fun execute() {
        // Insert row in the cart table
        cart.addToCart(item)
        println("placing $item in cart")
    }

    override fun unexecute() {
        // Delete row from the cart table
        cart.removeFromCart(item)
        println("removing $item in cart")
    }
}

abstract class BankAccount() {
    private var savings: Int = 0
    private var checking: Int = 0
    private var creditCardDebt: Int = 0
}


interface Bank {
    var savings: Int
    var checking: Int
    var creditCardDebt: Int

    fun addDeposit(
        amount: Int
    )

    fun makePayment(
        amount: Int
    )

    fun payToDebt(
        amount: Int
    )
}

class NavyFederal : Bank {
    override var savings: Int = 100
    override var checking: Int = 300

    override var creditCardDebt = 4000

    override fun addDeposit(amount: Int) {
        checking += amount
    }

    override fun makePayment(amount: Int) {
        checking -= amount
    }

    override fun payToDebt(amount: Int) {
        creditCardDebt -= amount
    }

    companion object {
        private var instance: NavyFederal? = null

        fun getNavyFederal(): NavyFederal {
            if (instance == null) {
                val bank = NavyFederal()
                instance = bank
            }
            return instance as NavyFederal
        }
    }
}

class BankOfAmerica : Bank {
    override var savings: Int = 1000
    override var checking: Int = 90

    override var creditCardDebt = 123

    override fun addDeposit(amount: Int) {
        checking += amount
    }

    override fun makePayment(amount: Int) {
        checking -= amount
    }

    override fun payToDebt(amount: Int) {
        creditCardDebt -= amount
    }

    companion object {
        private var instance: BankOfAmerica? = null

        fun getBankOfAmerica(): BankOfAmerica {
            if (instance == null) {
                val bank = BankOfAmerica()
                instance = bank
            }
            return instance as BankOfAmerica
        }
    }
}


class PayBill(
    private val bank: Bank,
    private val amount: Int
) : Command {
    override fun execute() {
        bank.payToDebt(amount)
    }

    override fun unexecute() {
        println("Can't cancell transaction please call an agent to reverse $amount")
    }

}


internal class Invoker(command: Command) {
    private val command: Command

    init {
        this.command = command
    }

    fun executeCommand() {
        command.execute()
    }

    fun unexecuteCommand() {
        command.unexecute()
    }
}

fun main() {
    val commandHistory = Stack<Command>()
    var command: Command = AddToCartCommand(Cart, "Apple")
    var invoker: Invoker = Invoker(command)
    invoker.executeCommand()
    commandHistory.push(command)

    invoker = Invoker(
        AddToCartCommand(item = "Banana")
    )

    invoker.executeCommand()


    Cart.getCart().forEach { item ->
        println("$item")
    }

    command = PayBill(
        NavyFederal.getNavyFederal(),
        300
    )
    invoker = Invoker(command)

    invoker.executeCommand()



    println(
        " my credit card debt after payment ${BankOfAmerica.getBankOfAmerica().creditCardDebt}"
    )

    invoker.unexecuteCommand()

    //   invoker.unexecuteCommand()
//    Cart.getCart().forEach { item ->
//        println("$item")
//    }
}