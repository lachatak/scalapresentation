package gamesys.presentation.visibility.outermodule.innermodule

//this class is only visible from the 'outermodule' package
private[innermodule] class InnerAppService

//this class is only visible from the 'outermodule' package
private[outermodule] class OuterAppService

//this class is only visible from the 'visibility' package
private[visibility] class SomeVisibleService
