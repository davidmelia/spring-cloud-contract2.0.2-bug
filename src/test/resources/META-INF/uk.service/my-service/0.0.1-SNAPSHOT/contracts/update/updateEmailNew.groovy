package contracts.update

org.springframework.cloud.contract.spec.Contract.make {
    request {
        name('update email given valid permission new')
        method 'PUT'
        url '/my-service/api/2/root/email'
        headers {
            contentType('application/json')
        }
        body('{"email": "updated-email@test.com"}')
    }
    response {
        status 204
    }
}
