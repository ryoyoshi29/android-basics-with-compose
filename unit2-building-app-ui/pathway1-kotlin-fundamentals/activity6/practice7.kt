open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isFold: Boolean):
Phone(isScreenLightOn = !isFold) {
    
    var isFold: Boolean = isFold
    
    override fun switchOn() {
        if(!isFold) {
            isScreenLightOn = true
        }
    }
    
    fun foldPhone() {
        isFold = true
    }
    
    fun openPhone() {
        isFold = false
    }
}

fun main() {
    val foldablePhone: FoldablePhone = FoldablePhone(false)
    foldablePhone.checkPhoneScreenLight()
}