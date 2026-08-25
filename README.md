# Adore Hair Studio — Spring Boot Full Stack

This project converts the original static Vercel website into a database-backed site with an admin portal.

## Structure

- `frontend/` — existing HTML/CSS/JS site, modified to read data from the API.
- `backend/` — Spring Boot REST API + PostgreSQL/H2 + JWT admin authentication.
- Admin portal: `BACKEND_URL/admin.html`

## What is dynamic now

- Products: add, edit, delete, hide/show, category, price, old price, featured flag, image URL.
- Services: add, edit, delete, hide/show.
- Testimonials: add, edit, delete, hide/show.
- Contact form: saves enquiries to the database.
- Admin messages: view, mark read, delete.
- Site settings: phone, WhatsApp, email, Instagram, address and hero text.

## Recommended free deployment

- Frontend: Vercel (keep your existing deployment).
- Spring Boot backend: Render free Web Service.
- PostgreSQL: Neon Free plan. Do NOT depend on Render Free Postgres for permanent data because its free databases expire after 30 days.
- Images: Cloudinary Free, or another persistent image host. Render Free Web Services have an ephemeral filesystem.

## Local development

Requirements: Java 17+, Maven.

```bash
cd backend
mvn spring-boot:run
```

The backend defaults to a local H2 file database. Open:

- API: `http://localhost:8080/api/public/products`
- Admin: `http://localhost:8080/admin.html`

Change these for deployment.

Serve the `frontend/` folder with a local static server on port 5500. `frontend/config.js` already points to `http://localhost:8080`.

## Deploy backend to Render

1. Put the project in GitHub.
2. In Render create a new **Web Service** from the repository.
3. Set the root directory to `backend`.
4. Use the included `Dockerfile` (or Render Blueprint if preferred).
5. Choose the Free instance.
6. Add these environment variables:

```text
DATABASE_URL=jdbc:postgresql://YOUR_NEON_HOST/YOUR_DB?sslmode=require
DATABASE_USERNAME=YOUR_NEON_USERNAME
DATABASE_PASSWORD=YOUR_NEON_PASSWORD
FRONTEND_URL=https://YOUR-VERCEL-SITE.vercel.app
ADMIN_EMAIL=your-admin-email@example.com
ADMIN_PASSWORD=use-a-long-unique-password
JWT_SECRET=use-a-random-secret-at-least-32-characters-long
```

Render also supplies `PORT`; the application reads it automatically.

## Connect Vercel frontend to Render

After Render gives you a URL such as:

```text
https://adore-hair-api.onrender.com
```

edit `frontend/config.js`:

```js
window.ADORE_API_BASE = 'https://adore-hair-api.onrender.com';
```

Then redeploy the `frontend/` folder to Vercel.

Your admin portal will be:

```text
https://adore-hair-api.onrender.com/admin.html
```

## Images

Existing images such as `wig2.jpg` continue to load from Vercel. For new products, upload the image to Cloudinary and paste its HTTPS URL into the Image URL field in the admin portal.

Do not upload images to the Render server filesystem on the free tier; those files are not persistent.

## Security notes

- Admin write endpoints are protected by JWT authentication.
- Admin passwords are stored using BCrypt, not plain text.
- Only the configured frontend origin is allowed by CORS in production.
- Never commit production database credentials, JWT secret, or admin password to GitHub.

## Current scope

The cart remains browser-side and checkout still directs the customer to contact the salon; no payment gateway or order-management workflow has been added yet. If ecommerce is needed, add `Order`, `OrderItem`, payment status, customer checkout and admin order management as a separate phase.
