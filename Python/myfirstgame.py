import turtle

window=turtle.Screen()
window.title("Pong by Shubham")
window.bgcolor("black")
window.setup(width=800, height=600)
window.tracer(0)

#score
score_A=0
score_B=0

#paddle A
paddle_A=turtle.Turtle()
paddle_A.speed(0)
paddle_A.shape("square")
paddle_A.color("white")
paddle_A.shapesize(stretch_wid=5,stretch_len=1)
paddle_A.penup()
paddle_A.goto(-350,0)

#paddle B
paddle_B=turtle.Turtle()
paddle_B.speed(0)
paddle_B.shape("square")
paddle_B.color("white")
paddle_B.shapesize(stretch_wid=5,stretch_len=1)
paddle_B.penup()
paddle_B.goto(350,0)

#Ball
ball=turtle.Turtle()
ball.speed(0)
ball.shape("circle")
ball.color("white")
ball.penup()
ball.goto(0,0)
ball.dx=0.3
ball.dy=-0.3

#Pen
pen=turtle.Turtle()
pen.speed(0)
pen.color("white")
pen.penup()
pen.hideturtle()
pen.goto(0,260)
pen.write("PlayerA: 0  PlayerB: 0", align="center", font=("Courier", 16, "normal"))

#Function to move the paddle using the keyboard
def paddle_A_up():
    y=paddle_A.ycor() 
    y+=20
    paddle_A.sety(y)
    if(paddle_A.ycor()>260):
        paddle_A.sety(260)

def paddle_A_down():
    y=paddle_A.ycor()
    y-=20
    paddle_A.sety(y)
    if(paddle_A.ycor()<-260):
        paddle_A.sety(-250)

def paddle_B_up():
    y=paddle_B.ycor() 
    y+=20
    paddle_B.sety(y)
    if(paddle_B.ycor()>260):
        paddle_B.sety(260)

def paddle_B_down():
    y=paddle_B.ycor()
    y-=20
    paddle_B.sety(y)
    if(paddle_B.ycor()<-260):
        paddle_B.sety(-250)
#keyboard binding
window.listen()
window.onkeypress(paddle_A_up,"w")
window.onkeypress(paddle_A_down,"s")
window.onkeypress(paddle_B_up,"Up")
window.onkeypress(paddle_B_down,"Down")
#main game loop
while True:
    window.update()

    #Move the ball
    ball.setx(ball.xcor()+ball.dx)
    ball.sety(ball.ycor()+ball.dy)

    #Border checking
    if ball.ycor()>290:
        ball.sety(290)
        ball.dy*=-1

    if ball.ycor()<-290:
        ball.sety(-290)
        ball.dy*=-1

    if ball.xcor()>390:
        ball.goto(0,0)
        ball.dx*=-1
        score_A +=1
        pen.clear()
        pen.write("PlayerA: {}  PlayerB: {}".format(score_A, score_B), align="center", font=("Courier", 16, "normal"))

    if ball.xcor()<-390:
        ball.goto(0,0)
        ball.dx *= -1
        score_B +=1
        pen.clear()
        pen.write("PlayerA: {}  PlayerB: {}".format(score_A, score_B), align="center", font=("Courier", 16, "normal"))


    #paddle and ball collisions

    if (ball.xcor()>340 and ball.xcor()<350) and (ball.ycor()<paddle_B.ycor() + 40 and ball.ycor() >paddle_B.ycor() - 40):
        ball.setx(340)
        ball.dx*=-1

    if(ball.xcor()<-340 and ball.xcor() >-350) and (ball.ycor()<paddle_A.ycor() + 40 and ball.ycor() >paddle_A.ycor() - 40):
        ball.setx(-340)
        ball.dx*=-1

