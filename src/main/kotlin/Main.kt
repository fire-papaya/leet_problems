/** Author temur.navoi
 *  Created on 3/26/21 21:01
 */

fun main() {
    val command = BasicCommand.GREET


}

class CommandsHandler() {
    private val handlers: List<GenericCommandHandler<BasicCommand>> = listOf(
        GreetCommandsHandler(),
        MoveCommandsHandler()
    )

    fun handle(command: BasicCommand) {
        val handler = handlers.find { it.support(command) } ?: throw RuntimeException("Handler not found")

        handler.handle(command)
    }
}

enum class BasicCommand {
    GREET,
    MOVE,
}

interface GenericCommandHandler<T> {
    fun support(command: T): Boolean
    fun handle(command: T): String
}

class GreetCommandsHandler : GenericCommandHandler<BasicCommand> {
    override fun support(command: BasicCommand): Boolean {
        return command == BasicCommand.GREET
    }

    override fun handle(command: BasicCommand): String {
        return "Hello, glad to see you"
    }
}

class MoveCommandsHandler : GenericCommandHandler<BasicCommand> {
    override fun support(command: BasicCommand): Boolean {
        return command == BasicCommand.MOVE
    }

    override fun handle(command: BasicCommand): String {
        return "I am moving towards you"
    }
}